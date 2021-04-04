package com.test.question.linkedlist;

public class Q10_Addtwonumber {

    public static Node addLinkedList(Node h1, Node h2) {
        Node n1 = h1, n2 = h2;
        Node head = new Node(n1.data + n2.data);
        Node n3 = head;
        Integer carry = head.data / 10;
        head.data = head.data % 10;
        while (null != n1.next && null != n2.next) {
            n1 = n1.next;
            n2 = n2.next;
            Node node = new Node(n1.data + n2.data + carry);
            carry = node.data / 10;
            node.data = node.data % 10;
            n3.next = node;
            n3 = n3.next;
        }
        if (null != n2.next){
            n1=n2;
        }
        while (null != n1.next) {
            n1 = n1.next;
            Node node = new Node(n1.data + carry);
            carry = node.data / 10;
            node.data = node.data % 10;
            n3.next = node;
            n3 = n3.next;

        }

        if (carry == 1) {
            n3.next = new Node(1);
        }
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
//        Node n6 = new Node(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next=n5;
//        n5.next=n6;

        Node n7 = new Node(9);
        Node n8 = new Node(9);
        Node n9 = new Node(9);
//        Node n10 = new Node(2);
//        Node n11 = new Node(9);
        n7.next = n8;
        n8.next = n9;
//        n9.next = n10;
//        n10.next=n11;




        Node head1 = n1;
        Node head2= n7;

        Node head = addLinkedList(Q1_ReverseLinkedList.reverseLinkedListInterative2(n1),Q1_ReverseLinkedList.reverseLinkedListInterative2(n7));
        head=Q1_ReverseLinkedList.reverseLinkedListInterative2(head);

        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }
}
