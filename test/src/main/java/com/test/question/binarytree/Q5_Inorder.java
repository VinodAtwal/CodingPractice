package com.test.question.binarytree;

import java.util.Stack;

public class Q5_Inorder {

    public static void inorderRecursion(Node node){
        if(node== null) return;
        inorderRecursion(node.left);
        System.out.println(node.data);
        inorderRecursion(node.right);
    }
    public static void inorderIterative(Node node){
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || node!= null){
            if(node!= null){
                stack.push(node);
                node= node.left;
            }else{
                node=stack.pop();
                System.out.print(node.data+" ");
                node=node.right;
            }

        }
    }


    public static void main(String[] args) {
        Node root = new Node(5);
        Node n1 = new Node(3);
        Node n2 = new Node(6);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(7);
        Node n6 = new Node(1);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.right=n5;
        n3.left=n6;
        Node root1 = new Node(10, new Node(20, new Node(40), new Node(60)), new Node(30));
//        inorderRecursion(root);
        inorderIterative(root);

        /*
                      5
                   /    \
                  3      6
                 / \    / \
                2   4   N   7
               / \
             1   N
        * */

    }
}
