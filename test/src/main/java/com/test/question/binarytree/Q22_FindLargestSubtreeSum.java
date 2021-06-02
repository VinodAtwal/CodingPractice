package com.test.question.binarytree;

public class Q22_FindLargestSubtreeSum {

    public static int sumMax=Integer.MIN_VALUE;

    public static int largestSumTree(Node root){
        if(root==null){
            return 0;
        }
        int sum= root.data+largestSumTree(root.left)+largestSumTree(root.right);
        sumMax=Math.max(sum,sumMax);
        return sum;
    }

    public static void main(String[] args) {

        Node root = new Node(-1, new Node(-2, new Node(4), new Node(5)), new Node(3, new Node(-6), new Node(2)));

        largestSumTree(root);
        System.out.println(sumMax);
 /*
                      5
                   /    \
                  6      8
                 / \    / \
                8   9   11   18
               / \
             11   18
        * */
    }
}
