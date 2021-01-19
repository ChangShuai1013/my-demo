package com.cs.leetcode.linked_list;

public class RandomNode {
    private int label;
    private RandomNode next;
    private RandomNode random;

    public RandomNode(int label) {
        this.label = label;
    }

    public RandomNode(int label, RandomNode next, RandomNode random) {
        this.label = label;
        this.next = next;
        this.random = random;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public RandomNode getNext() {
        return next;
    }

    public void setNext(RandomNode next) {
        this.next = next;
    }

    public RandomNode getRandom() {
        return random;
    }

    public void setRandom(RandomNode random) {
        this.random = random;
    }
}
