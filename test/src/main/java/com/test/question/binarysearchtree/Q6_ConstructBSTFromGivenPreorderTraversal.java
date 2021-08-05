package com.test.question.binarysearchtree;


public class Q6_ConstructBSTFromGivenPreorderTraversal {
    public static int index = 0;


    public static Node constructBinaryTreeFromPreOrder(int[] array, int min, int max) {
        Node node = null;
        if (index < array.length && array[index] > min && array[index] < max) {
            node = new Node(array[index]);
            index++;
            node.left = constructBinaryTreeFromPreOrder(array, min, node.data);
            node.right = constructBinaryTreeFromPreOrder(array, node.data, max);
        }
        return node;
    }

    public static void preorderRecursion(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorderRecursion(node.left);
        preorderRecursion(node.right);

    }

    public static void main(String[] args) {
//        int[] arr = {10, 5, 1, 7, 40, 50};
        int[] arr = {60, 33, 4, 12, 41, 37, 38, 39, 44, 89, 75, 64, 90};
        Node node = constructBinaryTreeFromPreOrder(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        preorderRecursion(node);


    }

}
