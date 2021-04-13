package com.test.question.binarytree;

import java.util.LinkedList;
import java.util.Stack;

public class Q6_Preorder {

    public static void preorderRecursion(Node node){
        if(node== null) return;
        System.out.print(node.data+" ");
        preorderRecursion(node.left);
        preorderRecursion(node.right);

    }
    public static void preorderIterative(Node node){
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        while(stack.size()>0){
            Node n =stack.pop();
            System.out.print(n.data+" ");
            if(n.right!= null) {stack.push(n.right);}
            if(n.left!= null) {stack.push(n.left);}

        }
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
//        preorderRecursion(root);
        preorderIterative(root);


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
