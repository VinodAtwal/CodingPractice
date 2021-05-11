package com.test.question.binarytree;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class Q1_LevelOrderTraversal {

    public static void levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node =queue.poll();
            if(node!=null) {
                System.out.print(node.data+" " );
                if(!(node.left==null && node.right==null)) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }else{
                System.out.print("Nl ");
            }
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
        /*
                      5
                   /    \
                  6      7
                 / \    / \
                8   9   N   10
               / \
             11   N
        * */
//        levelOrderTraversal(root);


    }
}
