package com.cs.sql.entity;

public class ColumnNode extends Node {
    private String name;
    private String alias;
    private String table;

    public ColumnNode() {
    }

    public ColumnNode(String name, String alias, String table) {
        this.name = name;
        this.alias = alias;
        this.table = table;
    }

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

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
