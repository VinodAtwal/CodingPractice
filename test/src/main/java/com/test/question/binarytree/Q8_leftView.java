package com.test.question.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q8_leftView {
//    public static  List<Integer> leftview = new ArrayList<>();

    public static void leftView(Node node , Integer height,List<Integer> leftView  ){
        if(leftView.size()==height){
            leftView.add(node.data);
        }
        if(node.left!= null) {
            leftView(node.left, height + 1,leftView);
        }

        if(node.right!= null){
            leftView(node.right,height+1,leftView);
        }
    }

    public static void leftViewIterative(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Integer noOfEelement = queue.size();

            for(Integer i = 1; i<=noOfEelement;i++){

                Node n1 = queue.poll();
                if(i==1){
                    System.out.println(n1.data+" ");
                }
                if(n1.left!= null)queue.add(n1.left);
                if(n1.right!= null)queue.add(n1.right);
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

    Node n7 = new Node(10);
    Node n8 = new Node(56);
    Node n9 = new Node(14);
    Node n10 = new Node(18);
    Node n11 = new Node(16);
    Node n12 = new Node(21);



    root.left=n1;
    root.right=n2;
    n1.left=n3;
    n1.right=n4;
    n2.right=n5;
    n3.left=n6;

    n4.left= n7;
    n7.right=n8;
    n8.right=n9;

    n2.left= n10;
    n10.left=n11;
    n11.right=n12;

       /*
                      5
                   /    \
                  3      6
                 / \    / \
                2   4   18   7
               / \  /   /
             1   N  10  16
                     \    \
                    56      21
                     \
                     14

    */



        Node root1 = new Node(10, new Node(20, new Node(40), new Node(60)), new Node(30));
        List<Integer> leftview = new ArrayList<>();
//    leftView(root,0,leftview);
        leftViewIterative(root);
    leftview.forEach(System.out::println);





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
