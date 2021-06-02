package com.test.question.linkedlist;

public class Q2_ReverseDLLInGivenGroup {

/*    public static DLLNode reverseDllInGivenGroup(DLLNode head ,int groupSize){
        DLLNode node =head,prev=null,currHead=null,curTail=head,returnHead=null;
        int curCount=0;
        while (node!=null){
            if(curCount<groupSize) {
                curCount++;

                if (prev != null) {

                    if (prev.prev == null) {
                        prev.next = null;
                    } else {
                        prev.next = prev.prev;
                    }
                    prev.prev = node;

                }else{
                    curTail=node;
                }

                prev = node;
            }else{
                if(currHead==null){
                    returnHead=node.prev;
                }else{
                    currHead.next=node;
                    node.prev=currHead;
                }
                currHead=curTail;
            }

        }

    }*/
}
