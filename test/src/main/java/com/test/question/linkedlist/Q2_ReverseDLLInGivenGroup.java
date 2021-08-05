package com.test.question.linkedlist;

import com.test.Utility.Pair;

public class Q2_ReverseDLLInGivenGroup {

    public static Pair<DLLNode, DLLNode> reverse(DLLNode head) {
        Pair<DLLNode, DLLNode> pair = new Pair<>(null, head);

        DLLNode prevHead = head.prev;
        DLLNode curNode = head.next;
        head.next = null;
        DLLNode temp;
        while (curNode != null) {
            temp = curNode.next;
            curNode.prev = null;
            curNode.next = head;
            head.prev = curNode;
            head = curNode;
            curNode = temp;

        }
        if (prevHead != null) {
            prevHead.next = head;
        }
        head.prev = prevHead;
        pair.setFirst(head);
        return pair;
    }

    public static Pair<DLLNode, DLLNode> giveRange(DLLNode head, int k) {
        Pair<DLLNode, DLLNode> pair = new Pair<>(head, null);
        DLLNode node = head;
        DLLNode prev = node;
        for (int i = 0; i < k && node != null; i++) {
            prev = node;
            node = node.next;
        }
        if (node != null) {
            node.prev = null;
            prev.next = null;
        }
        pair.setSecond(node);
        return pair;
    }

    public static DLLNode reverseInGroup(DLLNode head, int k) {
        DLLNode mainHead = null;
        while (true) {
            Pair<DLLNode, DLLNode> pair = giveRange(head, k);
            System.out.println(pair.getFirst() + " " + pair.getSecond());

            Pair<DLLNode, DLLNode> pairRev = reverse(pair.getFirst());

            if (mainHead == null) {
                mainHead = pairRev.getFirst();
            }
            pairRev.getSecond().next = pair.getSecond();
            if (pair.getSecond() == null) {
                break;
            }
            pair.getSecond().prev = pairRev.getSecond();
            head = pair.getSecond();


        }
        return mainHead;
    }

    public static void main(String[] args) {
        DLLNode node1 = new DLLNode(1);
        DLLNode node2 = new DLLNode(2);
        DLLNode node3 = new DLLNode(3);
        DLLNode node4 = new DLLNode(4);
        DLLNode node5 = new DLLNode(5);
        DLLNode node6 = new DLLNode(6);
        DLLNode node7 = new DLLNode(7);

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;
        node6.next = node7;
        node7.prev = node6;

        DLLNode node = reverseInGroup(node1, 1);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }

    }
}
