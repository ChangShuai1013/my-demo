package com.cs.sql;

import com.cs.sql.entity.*;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;

import java.util.ArrayList;
import java.util.List;

public class SqlParser {
    public static void main(String[] args) throws JSQLParserException {
        String sql = "select t1.id, getFirst(getSecond(t1.name), t1.name) as name from table1 t1 where time > `${startTime}`";
        SqlParser sqlParser = new SqlParser();
        RootNode rootNode = sqlParser.parseSql(sql);
        System.out.println(rootNode);
    }

    public RootNode parseSql(String sql) throws JSQLParserException {
        RootNode rootNode = new RootNode();
        Statement statement = CCJSqlParserUtil.parse(sql);
        Select select = (Select) statement;
        PlainSelect plain = (PlainSelect) select.getSelectBody();
        List<SelectItem> selectItems = plain.getSelectItems();
        List<Node> selectColumns = new ArrayList<>();
        //解析select后的列
        parseSelectItem(selectItems, selectColumns);
        KeywordNode selectNode = new KeywordNode("select", NodeType.SELECT);
        selectNode.setChildren(selectColumns);
        rootNode.addChildren(selectNode);
        //解析from后的表
        FromItem fromItem = plain.getFromItem();
        List<Node> fromTables = new ArrayList<>();
        parseFromItem(fromItem, fromTables);
        KeywordNode fromNode = new KeywordNode("from", NodeType.FROM);
        fromNode.setChildren(fromTables);
        rootNode.addChildren(fromNode);
        return rootNode;
    }

    public void parseFromItem(FromItem fromItem, List<Node> fromTables) {
        TableNode tableNode = new TableNode();
        tableNode.setText(fromItem.toString());
        Alias alias = fromItem.getAlias();
        if (alias != null) {
            tableNode.setAlias(alias.getName());
        }
        fromTables.add(tableNode);
    }

    public void parseSelectItem(List<SelectItem> selectItems, List<Node> selectColumns) {
        if (selectItems != null) {
            for (SelectItem selectItem : selectItems) {
                if (selectItem instanceof SelectExpressionItem) {
                    SelectExpressionItem selectExpressionItem = (SelectExpressionItem) selectItem;
                    Alias alias = selectExpressionItem.getAlias();
                    Expression expression = selectExpressionItem.getExpression();
                    if (expression instanceof Column) {
                        ColumnNode column = new ColumnNode();
                        column.setName(((Column) expression).getColumnName());
                        column.setTable(((Column) expression).getTable().getSchemaName());
                        if (alias != null) {
                            column.setAlias(alias.getName());
                        }
                        selectColumns.add(column);
                    } else if (expression instanceof Function) {
                        KeywordNode function = new KeywordNode(((Function) expression).getName(), NodeType.FUNCTION);
                        List<Node> params = new ArrayList<>();
                        parseFunction((Function) expression, params);
                        function.setChildren(params);
                        selectColumns.add(function);
                    }
                }
            }
        }
    }

    public void parseFunction(Function selectItem, List<Node> params) {
        for (Expression expression : selectItem.getParameters().getExpressions()) {
            if (expression instanceof Column) {
                ColumnNode column = new ColumnNode();
                column.setName(((Column) expression).getColumnName());
                column.setTable(((Column) expression).getTable().getSchemaName());
                params.add(column);
            } else if (expression instanceof Function) {
                KeywordNode function = new KeywordNode(((Function) selectItem).getName(), NodeType.FUNCTION);
                List<Node> param = new ArrayList<>();
                parseFunction((Function) expression, param);
                function.setChildren(param);
                params.add(function);
            }
        }
    }
}
