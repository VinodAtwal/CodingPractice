package com.test.question.binarysearchtree;

import java.util.Stack;

public class Q5_KthLargestInBST {

    public static int kthLargestInBST(Node node, int k){
        Stack<Node> stack = new Stack<>();
        int count=0;
        while (!stack.isEmpty() || node!=null){
            if(node!=null){
                stack.push(node);
                node=node.right;
            }else{
                Node node1 = stack.pop();
                ++count;
                if(k==count){
                    return node1.data;
                }
                node=node1.left;
            }
        }
        System.out.println("there is not enough element in BST");
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Node root = BinarySearchTree.insert(null, 60);
        BinarySearchTree.insert(root, 33);
        BinarySearchTree.insert(root, 89);
        BinarySearchTree.insert(root, 90);
        BinarySearchTree.insert(root, 4);
        BinarySearchTree.insert(root, 12);
        BinarySearchTree.insert(root, 41);
        BinarySearchTree.insert(root, 44);
        BinarySearchTree.insert(root, 37);
        BinarySearchTree.insert(root, 38);
        BinarySearchTree.insert(root, 39);
        BinarySearchTree.insert(root, 75);
        BinarySearchTree.insert(root, 64);

        System.out.println( kthLargestInBST(root,3));



    }
}
