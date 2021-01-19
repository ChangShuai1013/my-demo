package com.cs.leetcode.linked_list;

import java.util.Objects;

/**
 * @author changshuai
 * @create 2020-08-04 22:26:44
 */
public class Node {
    private int value;
    private Node node;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node node) {
        this.value = value;
        this.node = node;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", node=" + node +
                '}';
    }
}
