package com.cs.leetcode.linked_list;

/**
 * @author changshuai
 * @create 2020-08-23 17:11:31
 *
 * 已知链表和数值x，将所有小于x的节点放在大于等于x的节点之后，且保持相对位置
 */
public class PartitionList {

    public Node partition(Node head, int x) {
        Node lessHead = new Node();
        Node lessPtr = lessHead;
        Node moreHead = new Node();
        Node morePtr = moreHead;
        while (head.getNode() != null) {
            if (head.getValue() < x) {
                lessPtr.setNode(head);
                lessPtr = head;
            } else {
                morePtr.setNode(head);
                morePtr = head;
            }
            head = head.getNode();
        }
        lessPtr.setNode(moreHead.getNode());
        moreHead.setNode(null);
        return lessHead.getNode();
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(4);
        Node c = new Node(3);
        Node d = new Node(2);
        Node e = new Node(5);
        Node f = new Node(2);
        a.setNode(b);
        b.setNode(c);
        c.setNode(d);
        d.setNode(e);
        e.setNode(f);
        PartitionList partitionList = new PartitionList();
        Node head = partitionList.partition(a, 3);
        while (head.getNode() != null) {
            System.out.println(head.getValue());
            head = head.getNode();
        }
    }
}
