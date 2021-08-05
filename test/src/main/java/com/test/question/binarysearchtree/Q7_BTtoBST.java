package com.test.question.binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q7_BTtoBST {

    public static int index = 0;

    public static Node btToBST(Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Collections.sort(list);
        inorderSet(root, list);
        return root;

    }

    public static void inorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static void inorderSet(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderSet(root.left, list);
        root.data = list.get(index);
        index++;
        inorderSet(root.right, list);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.left = n2;
        n2.left = n3;
        n3.right = n4;
        n1.right = n5;
        /*          1
                   /  \
        *         2     5
                 /
                 3
                 \
                   4
          * */

        Node node = btToBST(n1);
        System.out.println(node);

    }
}
