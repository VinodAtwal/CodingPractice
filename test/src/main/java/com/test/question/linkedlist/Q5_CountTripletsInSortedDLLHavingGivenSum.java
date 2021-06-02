package com.test.question.linkedlist;

import java.util.HashSet;

public class Q5_CountTripletsInSortedDLLHavingGivenSum {

    public static int countPairOfGivenSum(DLLNode startNode,DLLNode endNode ,int sum){
        int count=0;
        while (startNode!=endNode && endNode.next!=startNode){
            int curSum=startNode.data+ endNode.data;
            if(curSum==sum){
                count++;
                startNode=startNode.next;
                endNode=endNode.prev;
            }else if(curSum<sum){
                startNode=startNode.next;
            }else{
                endNode=endNode.prev;
            }
        }
        return count;
    }

    public static int countTripletOfGivenSum(DLLNode head,int sum){
        DLLNode endNode=head;
        while (endNode.next!=null){
            endNode=endNode.next;
        }
        int countTriplet=0;
        while (head.next!=null && head.next!=endNode){
            countTriplet+=countPairOfGivenSum(head.next,endNode,sum - head.data);
            head=head.next;
        }
        return countTriplet;
    }


    public static void main(String[] args) {
        DLLNode head = new DLLNode(1);
        DLLNode node2 = new DLLNode(2);
        DLLNode node3 = new DLLNode(3);
        DLLNode node4 = new DLLNode(4);
        DLLNode node5 = new DLLNode(5);
        DLLNode node6 = new DLLNode(6);
        DLLNode node7 = new DLLNode(7);
        DLLNode node8 = new DLLNode(8);
        DLLNode node9 = new DLLNode(9);
        head.next=node2; node2.next=node3;
        node3.next=node4; node4.next=node5;
        node5.next=node6; node6.next=node7;
        node7.next=node8; node8.next=node9;
        node2.prev=head;  node3.prev=node2;
        node4.prev=node3; node5.prev=node4;
        node6.prev=node5; node7.prev=node6;
        node8.prev=node7; node9.prev=node8;

        System.out.println(countTripletOfGivenSum(head,22));

    }

}
