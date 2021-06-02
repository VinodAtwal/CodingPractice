package com.test.question.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q24_PrintAllKSumPathsInBT {

    public static void printAllKSumPathInBT(Node node,int givenSum ,List<Integer> pathTrack){
        if(node==null){
            return;
        }
        pathTrack.add(node.data);
        printAllKSumPathInBT(node.left,givenSum ,pathTrack);
        printAllKSumPathInBT(node.right,givenSum ,pathTrack);
        int sum=0;
        String s="";
        int index= pathTrack.size()-1;

        while (index>=0){
            sum+=pathTrack.get(index);
            s=pathTrack.get(index)+" "+s;
            if(sum==givenSum){
                System.out.println(s);
            }
            index--;
        }

        pathTrack.remove(pathTrack.size()-1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(   1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(6);


        printAllKSumPathInBT(root,5,new ArrayList<Integer>());


          /*
                                1
                            /     \
                          3        -1
                        /   \     /   \
                       2     1   4     5
                            /   / \     \
                           1   1   2     6
        * */
    }
}
