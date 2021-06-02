package com.test.question.heap;

import java.util.PriorityQueue;

public class Q5_KthLargestSumContiguousSubarray {

    public static int kthLargestSumContiguousSubArray(int arr[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        int[] sumArray = new int[arr.length + 1];
        sumArray[0] = 0;
        sumArray[1] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sumArray[i + 1] = sumArray[i] + arr[i];
        }

        for (int i = 0; i < sumArray.length - 1; i++) {
            for (int j = i + 1; j < sumArray.length; j++) {
                int val = sumArray[j] - sumArray[i];
                if (minHeap.size() < k) {
                    minHeap.add(val);
                } else if (minHeap.peek() < val) {
                    minHeap.poll();
                    minHeap.add(val);
                }
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int arr[] = {-1};
        int k = 3;
        System.out.println(kthLargestSumContiguousSubArray(arr, k));
    }
}
