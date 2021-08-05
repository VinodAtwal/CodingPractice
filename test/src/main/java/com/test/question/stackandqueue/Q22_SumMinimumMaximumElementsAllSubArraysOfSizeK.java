package com.test.question.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

public class Q22_SumMinimumMaximumElementsAllSubArraysOfSizeK {

    public static int sumMinimumMaximumElementsAllSubArraysOfSizeK(int[] array, int k) {
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!min.isEmpty() && array[min.getLast()] > array[i]) {
                min.removeLast();
            }
            while (!max.isEmpty() && array[max.getLast()] < array[i]) {
                max.removeLast();
            }
            min.addLast(i);
            max.addLast(i);
        }
        int sum = array[min.peek()] + array[max.peek()];

        for (int i = k; i < array.length; i++) {

            while (!min.isEmpty() && array[min.getLast()] > array[i]) {
                min.removeLast();
            }
            while (!max.isEmpty() && array[max.getLast()] < array[i]) {
                max.removeLast();
            }
            min.addLast(i);
            max.addLast(i);

            while (min.getFirst() <= i - k) {
                min.removeFirst();
            }

            while (max.getFirst() <= i - k) {
                max.removeFirst();
            }

            sum += array[min.getFirst()] + array[max.getFirst()];


        }
        return sum;

    }


    public static void main(String[] args) {
        int arr[] = {5, 9, 8, 3, -4, 2, 1, -5};
        int k = 4;
        System.out.println(sumMinimumMaximumElementsAllSubArraysOfSizeK(arr, k));
    }
}
