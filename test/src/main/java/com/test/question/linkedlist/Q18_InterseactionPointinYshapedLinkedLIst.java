package com.test.question.linkedlist;

import java.util.Optional;

public class Q18_InterseactionPointinYshapedLinkedLIst {

    public static Optional<Integer> intersectionPoint(Node l1, Node l2){
        Node l1i=l1,l2i=l2,n1;
        Integer joinPoint = null;
        // checking for small list and putting in cycle
        while(l1i.next!=null && l2i.next!=null){
            l1i=l1i.next;
            l2i=l2i.next;
        }
        if(l1i.next==null){
            l1i.next=l1;
            n1=l2;
        }else{
            l2i.next=l2;
            n1=l1;
        }
        Node slow=n1,fast=n1;
        while(slow.next!=null && fast.next!=null && fast.next.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) {
                break;
            }

        }
        if(slow.next==null || fast.next==null||fast.next.next==null){
            return Optional.ofNullable(-1);
        }

        if(n1==slow && n1==fast){
            return Optional.ofNullable(n1.data);
        }
        fast=n1;
        while(fast.next!=slow.next){
            slow=slow.next;
            fast=fast.next;
        }
        joinPoint=slow.next.data;


        return Optional.ofNullable(joinPoint);
    }

    public static void main(String[] args) {
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        Node n6= new Node(6);
        Node n7= new Node(7);
        Node n8= new Node(8);
        Node n9= new Node(9);
        Node n10= new Node(10);
//        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;
//        n7.next=n8;n8.next=n4;

       n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6; n6.next=n7;

       n7.next=n8;n8.next=n9;n9.next=n10;


        System.out.println(intersectionPoint(n1,n7).get());




    }

}
