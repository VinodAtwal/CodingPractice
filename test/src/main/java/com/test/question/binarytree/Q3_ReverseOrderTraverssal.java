package com.test.question.binarytree;

import java.util.ArrayList;

public class Q3_ReverseOrderTraverssal {
    public static void reverseOrderTraversal(Node node){
        ArrayList<Node> arr = new ArrayList<>();
        arr.add(node);
        Integer i=0;
        while(i< arr.size()){
            if(arr.get(i).right!=null){
                arr.add(arr.get(i).right);
            }
            if(arr.get(i).left!=null){
                arr.add(arr.get(i).left);
            }
            i++;
        }
        i= arr.size()-1;
        while(i>=0){
            System.out.print(arr.get(i).data+" ");
            i--;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Node n1 = new Node(6);
        Node n2 = new Node(7);
        Node n3 = new Node(8);
        Node n4 = new Node(9);
        Node n5 = new Node(10);
        Node n6 = new Node(11);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.right=n5;
        n3.left=n6;
        reverseOrderTraversal(root);

        /*
                      5
                   /    \
                  6      7
                 / \    / \
                8   9   N   10
               / \
             11   N
        * */

    }
}
