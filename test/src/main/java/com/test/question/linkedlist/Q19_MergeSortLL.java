package com.test.question.linkedlist;

public class Q19_MergeSortLL {

    public static Node merge(Node left, Node right) {
        Node head = null;
        Node tail = null;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.data < right.data) {
            head = left;
            left = left.next;
        } else {
            head = right;
            right = right.next;
        }
        tail = head;

        while (left != null && right != null) {
            if (left.data < right.data) {
                tail.next = left;
                tail = left;
                left = left.next;
            } else {
                tail.next = right;
                tail = right;
                right = right.next;
            }
        }
        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }
        return head;
    }

    public static Node mergeSort(Node head) {

        Node nodeFirst = head;
        Node nodeSecond = head;

        while (nodeSecond != null && nodeSecond.next != null && nodeSecond.next.next != null) {
            nodeFirst = nodeFirst.next;
            nodeSecond = nodeSecond.next.next;
        }
        Node leftHead = head;
        Node rightHead = nodeFirst.next;
        nodeFirst.next = null;

        if (rightHead == null) {
            return leftHead;
        }
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);


        return merge(leftHead, rightHead);

    }

    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(4);
        Node n3 = new Node(6);
        Node n4 = new Node(2);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
        n4.next = n5;
        Node head = n1;
        Node node = head;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
        System.out.println();
        head = mergeSort(head);
        node = head;

        while (node != null) {
            System.out.println(node);
            node = node.next;
        }

    }
}
