package com.test.question.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q13_DiagonalTraversal {

    public static void diagonalTraversal(Node node){
        Queue<Node> queue  = new LinkedList<>();
        while(node!=null) {
            queue.add(node);
            node=node.right;
        }
        while(!queue.isEmpty()){
            Node n1 = queue.poll();
            System.out.print(n1.data+" ");
            n1= n1.left;
            while(n1!=null) {
                queue.add(n1);
                n1=n1.right;
            }
        }

    }
    public static void diagonalTraversalMayankDeque(Node node){
        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(node);
        while(!deque.isEmpty()) {
            Node n1 = deque.removeFirst();
            System.out.print(n1.data+" ");
            if(n1.left!=null){
                deque.addLast(n1.left);
            }
            if(n1.right!=null){
                deque.addFirst(n1.right);
            }
        }

    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        diagonalTraversal(root);
        System.out.println();
        diagonalTraversalMayankDeque(root);
          /*
                      5
                   /    \
                  6      7
                 / \    / \
                8   9      10
               / \
             11   N
        * */

    }


}
