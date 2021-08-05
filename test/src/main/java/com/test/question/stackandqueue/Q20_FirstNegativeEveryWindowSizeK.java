package com.test.question.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Q20_FirstNegativeEveryWindowSizeK {

    public static void firstNegativeEveryWindowSizeKOptimal(int[] array, int k) {
        int firstNegativeIndex = 0;
        for (int i = k - 1; i < array.length; i++) {

            while (firstNegativeIndex < i && (firstNegativeIndex <= i - k || array[firstNegativeIndex] > 0)) {
                firstNegativeIndex++;
            }

            if (array[firstNegativeIndex] < 0) {
                System.out.print(array[firstNegativeIndex] + " ");
            } else {
                System.out.print("0 ");
            }

        }
    }

    public static void firstNegativeEveryWindowSizeKQueue(int[] array, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            if (array[i] < 0) {
                queue.add(i);
            }
        }

        for (int i = k - 1; i < array.length; i++) {
            if (array[i] < 0) {
                queue.add(i);
            }
            if (!queue.isEmpty()) {
                System.out.print(array[queue.peek()] + " ");
                if (queue.peek() == i - (k - 1)) {
                    queue.poll();
                }
            } else {
                System.out.print("0 ");
            }

        }


    }

    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        firstNegativeEveryWindowSizeKOptimal(arr, 2);
        System.out.println();
        firstNegativeEveryWindowSizeKQueue(arr, 2);
        System.out.println();
        int[] arr1 = {12, -1, -7, 8, -15, 30, 16, 28};
        firstNegativeEveryWindowSizeKOptimal(arr1, 3);
        System.out.println();
        firstNegativeEveryWindowSizeKQueue(arr1, 3);
        System.out.println();
        int[] arr2 = {12, 1, 7, -8, -15, 30, 16, -28};
        firstNegativeEveryWindowSizeKOptimal(arr2, 4);
        System.out.println();
        firstNegativeEveryWindowSizeKQueue(arr2, 4);
        System.out.println();
        int[] arr3 = {-1, -2, -3, -4, -5, -6};
        firstNegativeEveryWindowSizeKOptimal(arr3, 3);
        System.out.println();
        firstNegativeEveryWindowSizeKQueue(arr3, 3);
    }
}
