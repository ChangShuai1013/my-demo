package com.cs.leetcode.linked_list;

/**
 * author:chang shuai
 * date:2020/10/8
 * time:10:22
 *
 * 合并两个有序链表
 */
public class MergeTwoSortedLists {
    public Node mergeTwoLists(Node l1, Node l2) {
        Node tempHead = new Node();
        Node ptr = tempHead;
        while (l1 != null && l2 != null) {
            if (l1.getValue() < l2.getValue()) {
                ptr.setNode(l1);
                l1 = l1.getNode();
            } else {
                ptr.setNode(l2);
                l2 = l2.getNode();
            }
            ptr = ptr.getNode();
        }
        if (l1 != null) {
            ptr.setNode(l1);
        }
        if (l2 != null) {
            ptr.setNode(l2);
        }
        return tempHead.getNode();
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(4);
        Node c = new Node(6);
        Node d = new Node(0);
        Node e = new Node(5);
        Node f = new Node(7);
        a.setNode(b);
        b.setNode(c);
        d.setNode(e);
        e.setNode(f);
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        Node head = mergeTwoSortedLists.mergeTwoLists(a, d);
        while (head != null) {
            System.out.println(head);
            head = head.getNode();
        }
    }
}
