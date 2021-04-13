package com.test.question.binarytree;

public class Q2_Diameter_Binary_Tree {
    public static Integer diameterOfTree= Integer.MIN_VALUE;

    public static Integer diameterOfTree(Node node){
        if(node== null) {return 0;}
        Integer lh = diameterOfTree(node.left);
        Integer rh = diameterOfTree(node.right);
        diameterOfTree= Math.max(diameterOfTree,lh+rh+1);
        return Math.max(lh,rh)+1;
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
        Node root1 = new Node(10, new Node(20, new Node(40), new Node(60)), new Node(30));
        diameterOfTree(root1);

        System.out.println(diameterOfTree);






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
