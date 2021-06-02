package com.test.question.binarysearchtree;

import java.util.Stack;

public class Q4_KthSmallestInBST {

    public static int kthSmallestInBST(Node node, int k){
        Stack<Node>  stack =  new Stack<>();
        int count=0;
        while(!stack.isEmpty() || node!=null ){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                Node n = stack.pop();
                ++count;
                if(count==k){
                    return n.data;
                }
                node =n.right;
            }
        }
        System.out.println("Element are less than expected");
        return  Integer.MIN_VALUE;
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

        System.out.println(kthSmallestInBST(root,3));

    }

}
