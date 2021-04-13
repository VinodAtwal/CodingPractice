package com.test.question.binarytree;

import java.util.Comparator;
import java.util.Stack;
import java.util.TreeSet;

public class Q7_PostOrder {
    public static void postorderRecursion(Node node){
        if(node== null){return;}
        postorderRecursion(node.left);
        postorderRecursion(node.right);
        System.out.print(node.data+" ");
    }

    public static void postorderIterative(Node node){
        Stack<Node> stack = new Stack<>();
        Stack<Node> sol = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            node = stack.pop();
            if(node.left!=null){
            stack.push(node.left);}
            if(node.right!=null){
            stack.push(node.right);}
            sol.push(node);
        }
        while(!sol.isEmpty()){
            System.out.print(sol.pop().data+" ");
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
//        postorderRecursion(root);
//        postorderIterative(root);


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
