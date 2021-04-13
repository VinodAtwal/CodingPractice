package com.test.question.binarytree;

public class LevelOrdertraversalOfGiverLevel {

    public static void levelOrderTraversalOfGivernLevel(Node root, Integer level){
        if(root == null)
            return;
        if(level==1){
            System.out.print(root.data+" ");
        }
        levelOrderTraversalOfGivernLevel(root.left,level-1);
        levelOrderTraversalOfGivernLevel(root.right,level-1);

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
        levelOrderTraversalOfGivernLevel(root,2);

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
