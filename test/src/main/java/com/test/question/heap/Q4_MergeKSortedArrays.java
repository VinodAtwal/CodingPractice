package com.test.question.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q4_MergeKSortedArrays {

    public static void mergeKSortedArrayHeap(int[][] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int k = arr.length;
        int[] index = new int[k];
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i][index[i]]);
            ++index[i];
        }

        while (!minHeap.isEmpty()) {
            int op = minHeap.poll();
            arrayList.add(op);
            System.out.print(op + ", ");
            for (int i = 0; i < k; i++) {

                if (arr[i][index[i] - 1] == op && index[i] < arr[0].length) {
                    minHeap.add(arr[i][index[i]]);
                    ++index[i];
                }
            }
        }
        System.out.println();
        System.out.println(arrayList);

    }

    public static void main(String[] args) {
//        int[][] arr = {{1, 2, 3, 4}, {2, 2, 3, 4},
//                {5, 5, 6, 6}, {7, 8, 9, 9}};
        int[][] arr = {{1, 2},
                {2, 2}};
        mergeKSortedArrayHeap(arr);
    }
}
