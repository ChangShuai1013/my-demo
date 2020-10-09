package com.cs.leetcode.linked_list;

import java.util.ArrayList;
import java.util.List;

/**
 * author:chang shuai
 * date:2020/10/8
 * time:10:35
 *
 * 合并n个有序链表
 * 法1：暴力合并
 * 法2：所有节点排序后两两相连
 * 法3：分治法两两合并
 */
public class MergeKSortedLists {
    /**
     * 分治法
     * @param lists
     * @return
     */
    public Node mergeKLists(List<Node> lists) {
        if (lists.isEmpty()) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }
        if (lists.size() == 2) {
            return mergeTwoLists(lists.get(0), lists.get(1));
        }
        int mid = lists.size() / 2;
        List<Node> subList1 = new ArrayList<>();
        List<Node> subList2 = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            subList1.add(lists.get(i));
        }
        for (int i = mid; i < lists.size(); i++) {
            subList2.add(lists.get(i));
        }
        Node l1 = mergeKLists(subList1);
        Node l2 = mergeKLists(subList2);
        return mergeTwoLists(l1, l2);
    }

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
        Node g = new Node(2);
        Node h = new Node(3);
        a.setNode(b);
        b.setNode(c);
        d.setNode(e);
        e.setNode(f);
        g.setNode(h);
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        List<Node> list = new ArrayList<>();
        list.add(a);
        list.add(d);
        list.add(g);
        Node head = mergeKSortedLists.mergeKLists(list);
        while (head != null) {
            System.out.println(head);
            head = head.getNode();
        }
    }
}
