package com.test.question.heap;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q2_SlindingWindowMaximum {

    public static void insertElement(Deque<Integer> deque, int data) {
        while (!deque.isEmpty() && deque.getLast() < data) {
            deque.removeLast();
        }
        deque.addLast(data);
    }

    public static void slidingWindowMaximumDeque(int[] arr, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        while (index < k) {
            insertElement(deque, arr[index]);
            index++;
        }
        System.out.print(deque.getFirst() + " ");


        while (index < arr.length) {
            if (arr[index - k] == deque.getFirst()) {
                deque.removeFirst();
            }
            insertElement(deque, arr[index]);
            
            index++;
            System.out.print(deque.getFirst() + " ");
        }


    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        slidingWindowMaximumDeque(arr, k);
    }
}
