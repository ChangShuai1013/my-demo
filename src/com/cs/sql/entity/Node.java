package com.cs.sql.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {
    private List<Node> children;
    //此节点的文字
    protected String text;
    //节点类型
    protected NodeType nodeType;

    public Node() {
        this.children = new ArrayList<>();
    }

    private List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public void addChildren(Node node) {
        this.children.add(node);
    }
}
