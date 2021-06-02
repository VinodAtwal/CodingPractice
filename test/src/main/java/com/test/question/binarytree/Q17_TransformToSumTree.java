package com.test.question.binarytree;

public class Q17_TransformToSumTree {
    public static int transformToSumTree(Node root){
        if(root==null){
            return 0;
        }
        int data = root.data;

        int leftData = transformToSumTree(root.left);
        int rightData =transformToSumTree(root.right);

        root.data=leftData+rightData;
        return data+root.data;

    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Node n1 = new Node(6);
        Node n2 = new Node(7);
        Node n3 = new Node(8);
        Node n4 = new Node(9);
        Node n5 = new Node(10);
        Node n6 = new Node(11);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        n3.left = n6;
        Node r = new Node(10, new Node(-2, new Node(8), new Node(-4)), new Node(6, new Node(7), new Node(5)));

      /*
                      5
                   /    \
                  6      7
                 / \    / \
                8   9   17   10
               / \
             11   N
        * */

        transformToSumTree(r);
        System.out.println(r);

    }

}
