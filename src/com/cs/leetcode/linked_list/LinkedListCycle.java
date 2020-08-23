package com.cs.leetcode.linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author changshuai
 * @create 2020-08-08 18:20:40
 *
 * 链表求环的头节点
 */
public class LinkedListCycle {

    //利用set
    public Node detectCycle_1(Node head) {
        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else{
                set.add(head);
            }
            head = head.getNode();
        }
        return null;
    }

    //快慢指针赛跑
    public Node detectCycle_2(Node head) {
        Node fast = head;
        Node slow = head;
        Node meet = null;
        while (fast != null) {
            slow = slow.getNode();
            fast = fast.getNode();
            if (fast == null) {
               return null;
            }
            fast = fast.getNode();
            if (fast == slow) {
                meet = fast;
                break;
            }
        }
        if (meet == null) {
            return null;
        }
        while (head != null && meet != null) {
            if (head == meet) {
                return head;
            }
            head = head.getNode();
            meet = meet.getNode();
        }
        return null;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.setNode(b);
        b.setNode(c);
        c.setNode(d);
        d.setNode(e);
        e.setNode(f);
        f.setNode(g);
        g.setNode(c);
        LinkedListCycle cycle = new LinkedListCycle();
        //Node head = cycle.detectCycle_1(a);
        Node head = cycle.detectCycle_2(a);
        System.out.println(head.getValue());
    }
}
