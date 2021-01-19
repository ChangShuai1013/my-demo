package com.cs.leetcode.linked_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 复杂链表深度复制，节点哪有一个指向本链表内任意某个节点的随机指针，该指针可以为空
 */
public class CopyListWithRandomPointer {

    public RandomNode copyRandomList(RandomNode head) {
        Map<RandomNode, Integer> nodeMap = new HashMap<>();
        List<RandomNode> nodeList = new ArrayList<>();
        RandomNode ptr = head;
        int i = 0;
        while (ptr != null) {
            nodeList.add(new RandomNode(ptr.getLabel()));
            nodeMap.put(ptr, i);
            ptr = ptr.getNext();
            i++;
        }
        ptr = head;
        i = 0;
        while (ptr != null) {
            if (i + 1 >= nodeList.size()) {
                nodeList.get(i).setNext(null);
            } else {
                nodeList.get(i).setNext(nodeList.get(i + 1));
            }
            if (ptr.getRandom() != null) {
                int id = nodeMap.get(ptr.getRandom());
                nodeList.get(i).setRandom(nodeList.get(id));
            }
            ptr = ptr.getNext();
            i++;
        }
        return nodeList.get(0);
    }

    public static void main(String[] args) {
        RandomNode a = new RandomNode(1);
        RandomNode b = new RandomNode(2);
        RandomNode c = new RandomNode(3);
        RandomNode d = new RandomNode(4);
        RandomNode e = new RandomNode(5);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        a.setRandom(c);
        b.setRandom(d);
        c.setRandom(c);
        e.setRandom(d);
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
        RandomNode head = copyListWithRandomPointer.copyRandomList(a);
        while (head != null) {
            System.out.print("label = " + head.getLabel() + " ");
            if (head.getRandom() != null) {
                System.out.print("rand = " + head.getRandom().getLabel() + "\n");
            } else {
                System.out.print("rand = null\n");
            }
            head = head.getNext();
        }
    }
}
