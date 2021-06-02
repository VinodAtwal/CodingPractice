package com.test.question.linkedlist;

public class Q4_FindPairsGivenSumInDDL {

    public static void findPairGivenSum(DLLNode head ,int sum){

        //setting up start node and tail node
        DLLNode startNode = head;
        DLLNode endNode = head;
        while(endNode.next!=null){
            endNode=endNode.next;
        }

        while (startNode!=endNode && endNode.next!=startNode ){
            int currSum= startNode.data+endNode.data;
            if(currSum==sum){
                System.out.println("( "+startNode.data+" "+ endNode.data+")");
                startNode=startNode.next;
                endNode=endNode.prev;
            }else if(currSum>sum){
                endNode=endNode.prev;
            }else{
                startNode=startNode.next;
            }
        }

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
        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=node9;
        node2.prev=head;
        node3.prev=node2;
        node4.prev=node3;
        node5.prev=node4;
        node6.prev=node5;
        node7.prev=node6;
        node8.prev=node7;
        node9.prev=node8;

        findPairGivenSum(head,7);




    }
}
