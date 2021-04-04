package com.test.question.linkedlist;

/*https://www.codingninjas.com/blog/2020/09/09/floyds-cycle-detection-algorithm/#:~:text=Given%20a%20linked%20list%20we,'tortoise%2Dhare'%20algorithm.*/
/*Distance travelled by slowPointer before meeting= x + y
Distance travelled by fastPointer before meeting = (x + y + z) + y
= x + 2y + z

Since fastPointer travels with double the speed of slowPointer, and time is constant for both when the reach the meeting
point. So by using simple speed, time and distance relation.

2(x+y)= x+2y+z
=> x+2y+z = 2x+2y
=> x=z
*/
public class Q3_DetectaLoopInLinked {

    public static Boolean loopIsPresent(Node head){
        Node n1= head;
        Node n2= head;
        while(null != n1 &&  null!= n2 && null!= n2.next ){
            if(n1.next == n2.next.next)
                return  true;
            n1= n1.next;
            n2=n2.next.next;
        }

        return  false;
    }

    public static Node removeLoop(Node head){
        Node n1= head;
        Node n2= head;
        Boolean loop= false;
        while(null != n1 &&  null!= n2 && null!= n2.next ){
            if(n1.next == n2.next.next){
                loop=true;
                break;
                }
            n1= n1.next;
            n2=n2.next.next;
        }
        if(loop){
            System.out.println("loop Exists. Resolving loop...");
            // looped at head and meet at head
            if(n1.next==head && n2.next.next==head){
                n1.next=null;
                return head;
            }else{
                n2=head;
                n1=n1.next;
                while(n1.next!=n2.next){
                    n2=n2.next;
                    n1=n1.next;
                }
                n1.next=null;
                return head;
            }

            }
            return null;
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
        n4.next=n5;
        n5.next=n2;
        Node head = n1;

        Node node = head;
        System.out.println();
        if(loopIsPresent(head)){
            System.out.println("loop is present ");
        }else{
            System.out.println("loop is not present");}

        head= removeLoop(head);
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }

    }
}
