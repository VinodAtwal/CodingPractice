package com.test.question.binarysearchtree;

import com.test.Utility.Pair;

import java.util.Collections;

public class Q1_PredecessorSuccessor {

    public static Pair<Integer, Integer>  predecessorSuccessor(Node root,Integer k) {
        Pair<Integer, Integer> pair = new Pair<>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Node node = root;
        while (node != null) {
            if (node.data < k) {
                pair.setFirst(Math.max(pair.getFirst(), node.data));
                node = node.right;
            } else if (node.data > k) {
                pair.setSecond(Math.min(pair.getSecond(), node.data));
                node = node.left;
            } else {
                Pair<Integer,  Integer> minPair= predecessorSuccessor(node.left,k);
                  pair.setFirst(Math.max(minPair.getFirst(),pair.getFirst()));
                node=node.right;

            }
        }
            if (pair.getFirst() == Integer.MIN_VALUE) {
                pair.setFirst(-1);
            }
            if (pair.getSecond() == Integer.MAX_VALUE) {
                pair.setSecond(-1);
            }
            return pair;

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

//        System.out.println(root);

        System.out.println(predecessorSuccessor(root,39 ));



    }
}
