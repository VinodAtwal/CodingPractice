package com.test.question.binarytree;

import com.test.Utility.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class Q10_TopView {

    public  static void topView(Node node ){
        Queue<Pair<Node ,Integer>> queue = new LinkedList<>();
        Deque<Node> deque = new  ArrayDeque();
        deque.add(node);
        queue.add(new Pair<>(node,0));
        Integer min =0;
        Integer max =0;

        while(!queue.isEmpty()){
            Integer size = queue.size();
            for(Integer i =1;i<=size;i++){
                Pair<Node,Integer>  p= queue.poll();
                if(p.getSecond()<min ) {
                    deque.addFirst( p.getFirst());
                    min=p.getSecond();
                }
                if(p.getSecond()>max ) {
                    deque.addLast( p.getFirst());
                    max=p.getSecond();
                }
                if(p.getFirst().getLeft()!=null){
                    queue.add(new Pair<>(p.getFirst().left,p.getSecond()-1 ));

                }
                if(p.getFirst().getRight()!=null){
                    queue.add(new Pair<>(p.getFirst().right,p.getSecond()+1 ));
                }
            }
        }

        deque.forEach((n)->System.out.println(n.data+" "));

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
        Node n13 = new Node(22);

        Node n14 = new Node(23);
        Node n15 = new Node(24);



        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.right=n5;
        n3.left=n6;

        n4.right= n7;
        n7.right=n8;
        n8.right=n9;
        n9.right=n14;
        n14.right= n15;

        n2.left= n10;
        n10.right=n11;
        n11.right=n12;
        n12.right=n13;
        topView(root);

       /*
                      5
                   /    \
                  3      6
                 / \    / \
                2   4   18   7
               / \  /    \
             1   N  10     16
                    /      \
                   56        21
                  /
                14
               /
              23
             /
            24
    */



        Node root1 = new Node(10, new Node(20, new Node(40), new Node(60)), new Node(30));
        Deque<Integer> topView = new ArrayDeque<>();







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
