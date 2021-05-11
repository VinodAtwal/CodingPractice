package com.test.question.binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Q2_PopulateInorderSuccessorforAllNodes {
    public static Integer prev =-1;

    public static void populateInorderSuccessorForAllNodes(Node node){
        if(node == null){return;}
        populateInorderSuccessorForAllNodes(node.right);
        System.out.println(node.data+" -> "+prev);
        prev=node.data;
        populateInorderSuccessorForAllNodes(node.left);
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

        populateInorderSuccessorForAllNodes(root);

        ArrayList arrayList= new ArrayList();





    }


}
