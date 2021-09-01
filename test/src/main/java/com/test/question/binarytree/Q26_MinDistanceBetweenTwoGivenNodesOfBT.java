package com.test.question.binarytree;

public class Q26_MinDistanceBetweenTwoGivenNodesOfBT {

    public static int findDist(Node root, int a, int b) {
        Node node = lca(root, a, b);

        int left = findLevel(node, a, 0);
        int right = findLevel(node, b, 0);
        return left + right;

    }

    public static int findLevel(Node node, int val, int level) {
        if (node == null) {
            return -1;
        }
        if (node.data == val) {
            return level;
        }
        int v = findLevel(node.left, val, level + 1);
        if (v == -1) {
            v = findLevel(node.right, val, level + 1);
        }
        return v;
    }

    public static Node lca(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right != null ? right : null;

    }
}
