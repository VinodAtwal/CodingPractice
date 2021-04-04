package com.test.question.linkedlist;

public class Q6_RemoveDuplicatesInSortedArray {

    public static void removeDuplicateInSortedArray(Node head){
        Node node =head;
        while (null != node && node.next != null) {
            if (node.data == node.next.data) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(2);
        Node n5 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next=n5;
        Node head = n1;

        Node node = head;
        System.out.println();
        removeDuplicateInSortedArray(head);
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }
}
