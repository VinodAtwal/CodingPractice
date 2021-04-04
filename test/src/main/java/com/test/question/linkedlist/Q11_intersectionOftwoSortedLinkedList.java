package com.test.question.linkedlist;

public class Q11_intersectionOftwoSortedLinkedList {

    public static  Node intersection(Node h1,Node h2){
        Node head=null,node=null;
        while(null!= h1 && null!=h2){
            if(h1.data==h2.data){
                if(head==null){
                   head= new Node(h1.data);
                   node=head;
                }else{
                    node.next=new Node(h1.data);
                    node=node.next;
                }
                h1=h1.next;
                h2=h2.next;
            }else if(h1.data< h2.data){
                h1=h1.next;
            }else{
                h2=h2.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
//        Node n6 = new Node(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next=n5;
//        n5.next=n6;

        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
//        Node n10 = new Node(2);
//        Node n11 = new Node(9);
        n7.next = n8;
        n8.next = n9;
//        n9.next = n10;
//        n10.next=n11;




        Node head=intersection(n1,n7);

        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }

}
