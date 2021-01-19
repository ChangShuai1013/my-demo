package com.cs.leetcode.linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author changshuai
 * @create 2020-08-05 18:57:41
 *
 * 求两个链表的交点
 */
public class InstersectionNode {

    //使用set进行查找
    public Node getIntersectionNode_1(Node headA, Node headB) {
        Set<Node> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.getNode();
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.getNode();
        }
        return null;
    }

    //将两个链表从尾部对齐后找到第一个相同节点
    public Node getInersectionNode_2(Node headA, Node headB) {
        int lengthA = getListLength(headA);
        int lengthB = getListLength(headB);
        if (lengthA > lengthB) {
            headA = forwardLongList(lengthA, lengthB, headA);
        } else {
            headB = forwardLongList(lengthB, lengthA, headB);
        }
        while (headA != null && headB != null) {
            if (headA.equals(headB)) {
                return headA;
            }
            headA = headA.getNode();
            headB = headB.getNode();
        }
        return null;
    }

    public int getListLength(Node head) {
        int length = 0;
        while (head != null) {
            head = head.getNode();
            length++;
        }
        return length;
    }

    public Node forwardLongList(int longLength, int shortLength, Node longHead) {
        int delta = longLength - shortLength;
        while (longHead != null && delta > 0) {
            longHead = longHead.getNode();
            delta--;
        }
        return longHead;
    }

    public static void main(String[] args) {
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node b1 = new Node(3);
        Node b2 = new Node(4);
        Node b3 = new Node(5);
        Node c1 = new Node(6);
        Node c2 = new Node(7);
        Node c3 = new Node(8);
        a1.setNode(a2);
        a2.setNode(c1);
        c1.setNode(c2);
        c2.setNode(c3);
        b1.setNode(b2);
        b2.setNode(b3);
        b3.setNode(c1);
        InstersectionNode instersectionNode = new InstersectionNode();
        Node result = instersectionNode.getInersectionNode_2(a1, b1);
        System.out.println(result);
    }
}
