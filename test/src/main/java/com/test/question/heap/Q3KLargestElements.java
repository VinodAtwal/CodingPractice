package com.test.question.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q3KLargestElements {

    public static void kLargestElementMinHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (minHeap.peek() < arr[i]) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        for (Integer integer : minHeap) {
            System.out.println(integer);
        }
    }

    public static void kLargestElementMaxHeap(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int j : arr) {
            maxHeap.add(j);
        }
        maxHeap.stream().limit(k).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int arr[] = {11, 3, 2, 1, 15, 5, 4, 5, 46, 88, 96, 50};
        int k = 3;
        kLargestElementMaxHeap(arr, k);
        kLargestElementMinHeap(arr, k);
    }
}
