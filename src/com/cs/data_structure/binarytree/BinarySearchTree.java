package com.cs.data_structure.binarytree;

/**
 * 二叉查找树
 * 若左子树不空，则其左子树上的所有节点的值均小于它根节点的值
 * 若右子树不空，则其右子树上的所有节点的值均小于它根节点的值
 * 他的左右子树也为二叉查找树
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    private BinaryNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(BinaryNode<T> root) {
        this.root = root;
    }

    public void insert(T val) {
        BinaryNode<T> node = new BinaryNode<>(val);
        if (root == null) {//如果是第一个节点，直接创建一个新的节点
            root = node;
        } else {
            BinaryNode<T> current = root;
            BinaryNode<T> parent;//current节点的父节点
            while (true) {//循环查找插入的位置
                parent = current;
                if (val.compareTo(parent.getData()) < 0) {//插入的值小于当前节点，从左子树查找
                    current = current.getLeft();
                    if (current == null) {//直到当前节点为null
                        parent.setLeft(node);//设置当前节点的父节点的左子节点为新创建的节点
                        return;
                    }
                } else {//插入的值大于等于当前节点，从右子树查找
                    current = current.getRight();
                    if (current == null) {//直到当前节点为null
                        parent.setRight(node);//设置当前节点的父节点的右子节点为新创建的节点
                        return;
                    }
                }
            }
        }
    }

    public BinaryNode<T> find(T val) {
        BinaryNode<T> current = root;
        while (val.compareTo(current.getData()) != 0) {
            if (val.compareTo(current.getData()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        if (current == null) {
            return null;
        }
        return current;
    }

    public boolean delete(T val) {
        return true;
    }
}
