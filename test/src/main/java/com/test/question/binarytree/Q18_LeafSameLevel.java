package com.test.question.binarytree;

public class Q18_LeafSameLevel {

    public static int leafAtSameLevel(Node root){

        if(root.left==null && root.right==null){
            return 1;
        }else if(root.left==null){
            return leafAtSameLevel(root.right)+1;
        }else if(root.right==null){
            return leafAtSameLevel(root.left)+1;
        }else{
           int right =leafAtSameLevel(root.right)+1;
           int left =leafAtSameLevel(root.left)+1;
           if(right==left){
               return right;
           }else{
               return -1;
           }
        }
    }

    public static void main(String[] args) {

        Node r = new Node(10, new Node(-2, new Node(8), new Node(-4)), new Node(6, new Node(7), new Node(5)));
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
        System.out.println(leafAtSameLevel(root));

    }


    }
