package com.test.question.binarytree;

public class Q14_BoundaryLevelTraversal {

    public static void  boundaryLevelTraversal(Node node){
        printLeftTree(node);
        printLeafNode(node);
        printRightNode(node);
        
    }

    private static void printRightNode(Node node) {
        if(node==null) return;
        if(node.right!=null){
            printRightNode(node.right);
            System.out.println(node.data+" ");
        }else if(node.left!=null){
            printRightNode(node.left);
            System.out.println(node.data+" ");
        }
    }

    private static void printLeafNode(Node node) {
        if(node==null) return;
        if(node.left==null && node.right==null){
            System.out.println(node.data+" ");
        }
        if(node.left!=null){
            printLeafNode(node.left);
        }
        if(node.right!=null){
            printLeafNode(node.right);
        }
    }

    private static void printLeftTree(Node node) {
        if(node==null) return;
        if(node.left!=null){
            System.out.println(node.data+" ");
            printLeftTree(node.left);
        }else if(node.right!=null){
            System.out.println(node.data+" ");
            printLeftTree(node.right);

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
//        Node n7 = new Node(23);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.right=n5;
        n3.left=n6;
        boundaryLevelTraversal(root);
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



    }
}
