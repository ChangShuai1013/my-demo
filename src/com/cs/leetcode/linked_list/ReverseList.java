package com.cs.leetcode.linked_list;

/**
 * @author changshuai
 * @create 2020-08-04 22:27:38
 *
 * 链表逆序
 */
public class ReverseList {

    public Node reverse(Node head) {
        Node newHead = null;
        while (head != null) {
            Node next = head.getNode();
            head.setNode(newHead);
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public Node reverseBetween(Node head, int m, int n) {
        int changeLen = n - m + 1;
        Node preHead = null;
        Node result = head;
        while (head != null && m-- > 0) {
            preHead = head;
            head = head.getNode();
        }
        Node modifyListTail = head;
        Node newHead = null;
        while (head != null && changeLen > 0) {
            Node next = head.getNode();
            head.setNode(newHead);
            newHead = head;
            head = next;
            changeLen--;
        }
        modifyListTail.setNode(head);
        if (preHead != null) {
            preHead.setNode(newHead);
        } else {
            result = newHead;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.setNode(b);
        b.setNode(c);
        c.setNode(d);
        d.setNode(e);
        Node head = a;
        System.out.println("before: ");
        while (head != null) {
            System.out.println(head.getValue() + " " + head);
            head = head.getNode();
        }
        System.out.println("after: ");
        //head = reverseList.reverse(a);
        head = reverseList.reverseBetween(a, 2, 4);
        while (head != null) {
            System.out.println(head.getValue() + " " + head);
            head = head.getNode();
        }
    }
}
