package com.cs.sql.entity;

import java.util.List;

public class TableNode extends Node {
    private String name;
    private String alias;
    private List<ColumnNode> columns;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<ColumnNode> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnNode> columns) {
        this.columns = columns;
    }
}
