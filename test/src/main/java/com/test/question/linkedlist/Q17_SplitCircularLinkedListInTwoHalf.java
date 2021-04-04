package com.test.question.linkedlist;


public class Q17_SplitCircularLinkedListInTwoHalf {

    public static Node[] splitLinkedList(Node head){

        Node n1=head,n2=head;
        while(n2.next!=head && n2.next.next!=head){
            n1=n1.next;
            n2=n2.next.next;
        }
        if(n2.next == head){
            n2.next=null;
        }else{
            n2.next.next=null;
        }
        n2=n1.next;
        n1.next=null;

        System.out.println();
        Node[] arr = {head,n2};
        return arr;

    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(9);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(2);
        Node n11 = new Node(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next=n11;
        n11.next=n1;
        Node [] arr= splitLinkedList(n1);
        for(Node n :arr){
            System.out.println("l1 ");
            while (n != null) {
                System.out.println(n);
                n = n.next;
            }
        }

    }
}
