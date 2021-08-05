package com.test.question.linkedlist;

public class Q1_ReverseLinkedList {

    public static Node reverserLinkedListRecursive(Node head) {
        Node node = head;
        if (head.next != null) {
            return head;
        }
        Node h2 = reverserLinkedListRecursive(head.next);
        node.next = null;
        Node n1 = h2;
        while (h2.next != null) {

        }

        return null;
    }

    public static Node reverseLinkedListInterative(Node head) {
        Node node = head;
        Node prev = head;
        while (node != null) {
            if (node == head) {
                node = node.next;
                continue;
            }
            Node temp = node;
            node = node.next;
            temp.next = head;
            head = temp;

            prev.next = node;

        }
        return head;
    }

    public static Node reverseLinkedListInterative2(Node head) {
        Node head1 = head;
        Node head2 = head.next;
        head1.next = null;
        while (head2 != null) {
            Node node = head2;
            head2 = head2.next;
            node.next = head1;
            head1 = node;
        }
        return head1;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Node head = n1;
//       head=reverseLinkedListInterative(head);
        head = reverseLinkedListInterative2(head);
        Node node = head;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }


    }
}
