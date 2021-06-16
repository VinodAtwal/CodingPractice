package com.test.question.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q7_FindSmallestRangeContainingElementsFromKLists {

    static class Node {
        int data;
        int arrayIndex;
        int nextElementIndex;

        public Node(int data, int arrayIndex, int nextElementIndex) {
            this.data = data;
            this.arrayIndex = arrayIndex;
            this.nextElementIndex = nextElementIndex;
        }
    }

    public static void findSmallestRangeContainingElementsFromKList(int[][] input) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((i, j) -> i.data - j.data);
        int row = input.length;
        int col = input[0].length;

        int max = Integer.MIN_VALUE;
        int minrange = Integer.MIN_VALUE;

        ArrayList<Integer> range = new ArrayList<>(2);

        for (int i = 0; i < input.length; i++) {
            int val = input[i][0];
            max = Math.max(max, val);
            minHeap.add(new Node(val, i, 1));
        }
        minrange = max - minHeap.peek().data;
        range.add(minHeap.peek().data);
        range.add(max);

        while (minHeap.size() == row) {
            Node node = minHeap.poll();
            if (node.nextElementIndex < col) {
                max = Math.max(max, input[node.arrayIndex][node.nextElementIndex]);
                minHeap.add(new Node(input[node.arrayIndex][node.nextElementIndex], node.arrayIndex, node.nextElementIndex + 1));

                if (max - minHeap.peek().data < minrange) {
                    minrange = max - minHeap.peek().data;
                    range.set(0, minHeap.peek().data);
                    range.set(1, max);
                }
            }
        }
        System.out.println(minrange + " " + range);
    }

    public static void main(String[] args) {
        int arr[][] =
//                {{0, 0, 0, 0, 0},
//                        {1, 1, 1, 1, 1},
//                        {1, 1, 1, 1, 1}};
                {{0, 1, 2, 3, 4},
                        {5, 6, 7, 8, 9},
                        {10, 12, 16, 30, 50}};

//                {{1, 3, 5, 7, 9},
//                {0, 2, 4, 6, 8},
//                {2, 3, 5, 7, 11}};
//                {{4, 7, 9, 12, 15},
//                {0, 8, 10, 14, 20},
//                {6, 12, 16, 30, 50}};
        findSmallestRangeContainingElementsFromKList(arr);

    }
}
