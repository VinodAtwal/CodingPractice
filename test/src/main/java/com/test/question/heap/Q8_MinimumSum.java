package com.test.question.heap;


import java.util.Arrays;
import java.util.PriorityQueue;

public class Q8_MinimumSum {

    public static int minimumSum(int arr[]) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.stream(arr).boxed().forEach(minHeap::add);
        String num1 = "";
        String num2 = "";

        while (!minHeap.isEmpty()) {
            num1 += minHeap.poll();
            if (!minHeap.isEmpty()) {
                num2 += minHeap.poll();
            }
        }
        return num1.isEmpty() ? 0 : num2.isEmpty() ? Integer.valueOf(num1) : Integer.valueOf(num1) + Integer.valueOf(num2);
    }

    public static void main(String[] args) {
        int[] arr = {6};
        System.out.println(minimumSum(arr));
    }
}

