package com.test.question.stackandqueue;

import com.test.question.binarytree.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Q21_CheckAllLevelsOfTwoTreesAreAnagramsOrNot {

    public static boolean checkAllLevelsOfTwoTreesAreAnagramsOrNot(Node root1, Node root2) {
        Queue<Node> queue1, queue2;
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();

        queue1.add(root1);
        queue2.add(root2);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int size1 = queue1.size();
            int size2 = queue2.size();

            if (size1 != size2) {
                return false;
            }

            while (size1 > 0 && size2 > 0) {

                Node n1 = queue1.poll();
                Node n2 = queue2.poll();

                if (n1.getLeft() != null) {
                    queue1.add(n1.getLeft());
                }
                if (n1.getRight() != null) {
                    queue1.add(n1.getRight());
                }
                if (n2.getLeft() != null) {
                    queue2.add(n2.getLeft());
                }
                if (n2.getRight() != null) {
                    queue2.add(n2.getRight());
                }

                hashMap.putIfAbsent(n1.getData(), 0);
                hashMap.putIfAbsent(n2.getData(), 0);
                hashMap.put(n1.getData(), hashMap.get(n1.getData()) + 1);
                hashMap.put(n2.getData(), hashMap.get(n2.getData()) - 1);

                size1--;
                size2--;
            }
            for (Integer val : hashMap.values()) {
                if (val != 0) {
                    return false;
                }
            }
        }

        return true;
    }

 
    public static void main(String[] args) {
        // Constructing both the trees.
        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.right.left = new Node(5);
        root1.right.right = new Node(4);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.left.right.left = new Node(5);
        root2.left.right.right = new Node(5);

        System.out.println(checkAllLevelsOfTwoTreesAreAnagramsOrNot(root1, root2) ?
                "Yes" : "No");


    }

}
