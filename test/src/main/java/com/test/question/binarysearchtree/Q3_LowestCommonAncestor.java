package com.test.question.binarysearchtree;

public class Q3_LowestCommonAncestor {

    public static Integer lowestCommonAncestor(Node root,Integer data1,Integer data2) {
        while (root != null) {
            if (data1 < root.data && data2 < root.data) {
                root = root.left;
            } else if (data1 > root.data && data2 > root.data) {
                root = root.right;
            } else { // at least 1 is maching OR one is smaller and one is greater
                return root.data;
            }
        }
        return null;
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

        System.out.println(lowestCommonAncestor(root,90,89));
    }

}
