package com.cs.sql.entity;

/**
 * SELECT,FROM,WHERE,LEFT_JOIN,ON
 */
public class KeywordNode extends Node {

    public KeywordNode(String name, NodeType nodeType) {
        this.text = name;
        this.nodeType = nodeType;
    }
}
