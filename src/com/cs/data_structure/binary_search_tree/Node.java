package com.cs.data_structure.binary_search_tree;

public class Node<T extends Comparable> {
    T value;
    Node<T> parent;
    Node<T> left;
    Node<T> right;

    public Node(T value, Node<T> parent, Node<T> left, Node<T> right) {
        super();
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node<T> other = (Node<T>) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
