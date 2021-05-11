package com.test.question.binarytree;

import com.test.Utility.Pair;

public class Q12_Check_BalancedTree {



    public static Pair<Boolean,Integer> treeBalanced(Node node){
        if(node==null) {return new Pair<Boolean, Integer>(true,0 ) ;}

        Pair<Boolean,Integer> left = treeBalanced(node.left) ;
        Pair<Boolean,Integer> right = treeBalanced(node.right);
        Boolean isBalanced = (left.getFirst() && right.getFirst()) && Math.abs(left.getSecond()- right.getSecond())<2;

        return new Pair<>(isBalanced,Math.max(left.getSecond(), right.getSecond() )+1) ;

    }


    public static void main(String[] args) {
//        Node root = new Node(5);
//        Node n1 = new Node(6);
//        Node n2 = new Node(7);
//        Node n3 = new Node(8);
//        Node n4 = new Node(9);
//        Node n5 = new Node(10);
//        Node n6 = new Node(11);
//        Node n7 = new Node(23);
//        root.left=n1;
//        root.right=n2;
//        n1.left=n3;
//        n1.right=n4;
//        n2.right=n5;
//        n3.left=n6;
//        n6.left=n7;
        /*
                      5
                   /    \
                  6      7
                 / \    / \
                8   9   N   10
               / \
             11   N
        * */

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


        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        n3.left = n6;

        n4.left = n7;
        n7.left = n8;
        n8.left = n9;
        n9.left = n14;
        n14.left = n15;

        n2.left = n10;
        n10.right = n11;
        n11.right = n12;
        n12.right = n13;
        Node root1 = new Node(10, new Node(20, new Node(40), new Node(60)), new Node(30));

        Pair<Boolean,Integer> pair = treeBalanced(root);
        if(pair.getFirst()) System.out.println("Balance");
        else System.out.println("notBalance");







    }
}
