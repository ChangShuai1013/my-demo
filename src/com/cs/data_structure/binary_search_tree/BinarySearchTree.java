package com.cs.data_structure.binary_search_tree;

/**
 * 二叉查找树
 * 若左子树不空，则其左子树上的所有节点的值均小于它根节点的值
 * 若右子树不空，则其右子树上的所有节点的值均小于它根节点的值
 * 他的左右子树也为二叉查找树
 */
public class BinarySearchTree<T extends Comparable> {
    private Node<T> root;
    private int size;

    public Node<T> insert(T element) {
        if (root == null) {
            root = new Node<>(element, null, null, null);
            size++;
            return root;
        }
        Node<T> insertParentNode = null;
        Node<T> searchTempNode = root;
        while (searchTempNode != null && searchTempNode.value != null) {
            insertParentNode = searchTempNode;
            if (element.compareTo(searchTempNode.value) < 0) {
                searchTempNode = searchTempNode.left;
            } else {
                searchTempNode = searchTempNode.right;
            }
        }
        Node<T> newNode = new Node<>(element, insertParentNode, null, null);
        if (insertParentNode.value.compareTo(newNode.value) < 0) {
            insertParentNode.left = newNode;
        } else {
            insertParentNode.right = newNode;
        }
        size++;
        return newNode;
    }

    public Node<T> search(T element) {
        Node node = root;
        while (node != null && node.value != null && node.value.compareTo(element) != 0) {
            if (element.compareTo(node.value) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public T getMinimum() {
        return getMinimum(root).value;
    }

    public Node<T> getMinimum(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public T getMaximum() {
        return getMaximum(root).value;
    }

    public Node<T> getMaximum(Node<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public Node<T> delete(T element) {
        Node<T> deleteNode = search(element);
        if (deleteNode != null) {
            return delete(deleteNode);
        } else {
            return null;
        }
    }

    private Node<T> delete(Node<T> deleteNode) {
        if (deleteNode != null) {
            Node<T> nodeToReturn = null;
            if (deleteNode.left == null) {
                nodeToReturn = transplant(deleteNode, deleteNode.right);
            } else if (deleteNode.right == null) {
                nodeToReturn = transplant(deleteNode, deleteNode.left);
            } else {
                Node<T> successorNode = getMinimum(deleteNode.right);
                if (successorNode.parent != deleteNode) {
                    transplant(successorNode, successorNode.right);
                    successorNode.right = deleteNode.right;
                    successorNode.right.parent = successorNode;
                }
                transplant(deleteNode, successorNode);
                successorNode.left = deleteNode.left;
                successorNode.left.parent = successorNode;
                nodeToReturn = successorNode;
            }
            size--;
            return nodeToReturn;
        }
        return null;
    }

    private Node<T> transplant(Node<T> nodeToReplace, Node<T> newNode) {
        if (nodeToReplace.parent == null) {
            this.root = newNode;
        } else if (nodeToReplace == nodeToReplace.parent.left) {
            nodeToReplace.parent.left = newNode;
        } else {
            nodeToReplace.parent.right = newNode;
        }
        if (newNode != null) {
            newNode.parent = nodeToReplace.parent;
        }
        return newNode;
    }

    public T getSuccessor(T element) {
        return getSuccessor(search(element)).value;
    }

    public Node<T> getSuccessor(Node<T> node) {
        if (node.right != null) {
            return getMinimum(node.right);
        } else {
            Node<T> currentNode = node;
            Node<T> parentNode = node.parent;
            while (parentNode != null && currentNode == parentNode.right) {
                currentNode = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        }
    }

    public T getPredecessor(T element) {
        return getPredecessor(search(element)).value;
    }

    public Node<T> getPredecessor(Node<T> node) {
        if (node.left != null) {
            return getMaximum(node.left);
        } else {
            Node<T> currentNode = node;
            Node<T> parentNode = node.parent;
            while (parentNode != null && currentNode == parentNode.left) {
                currentNode = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        }
    }

    public void printTreeInOrder() {
        printTreeInOrder(root);
    }

    public void printTreePreOrder() {
        printTreePreOrder(root);
    }

    public void printTreePostOrder() {
        printTreePostOrder(root);
    }

    private void printTreeInOrder(Node<T> entry) {
        if (entry != null) {
            printTreeInOrder(entry.left);
            if (entry.value != null) {
                System.out.println(entry.value);
            }
            printTreeInOrder(entry.right);
        }
    }

    private void printTreePreOrder(Node<T> entry) {
        if (entry != null) {
            if (entry.value != null) {
                System.out.println(entry.value);
            }
            printTreeInOrder(entry.left);
            printTreeInOrder(entry.right);
        }
    }

    private void printTreePostOrder(Node<T> entry) {
        if (entry != null) {
            printTreeInOrder(entry.left);
            printTreeInOrder(entry.right);
            if (entry.value != null) {
                System.out.println(entry.value);
            }
        }
    }

    public void printTree() {
        printSubtree(root);
    }

    public void printSubtree(Node<T> node) {
        if (node.right != null) {
            printTree(node.right, true, "");
        }
        printNodeValue(node);
        if (node.left != null) {
            printTree(node.left, false, "");
        }
    }

    private void printNodeValue(Node<T> node) {
        if (node.value == null) {
            System.out.print("<null>");
        } else {
            System.out.print(node.value.toString());
        }
        System.out.println();
    }

    private void printTree(Node<T> node, boolean isRight, String indent) {
        if (node.right != null) {
            printTree(node.right, true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodeValue(node);
        if (node.left != null) {
            printTree(node.left, false, indent + (isRight ? " |      " : "        "));
        }
    }
}
