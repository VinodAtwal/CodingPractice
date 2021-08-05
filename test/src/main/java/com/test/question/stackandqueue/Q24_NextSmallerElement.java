package com.test.question.stackandqueue;

import java.util.Stack;

public class Q24_NextSmallerElement {

    public static void nextSmallerElement(int[] array) {
        Stack<Integer> stack = new Stack<>();

        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > array[i]) {
                stack.pop();
            }
            System.out.println(array[i] + " --> " + (stack.isEmpty() ? -1 : stack.peek()));

            stack.push(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] array =
//                {11, 13, 21, 3};
//                {13, 7, 6, 12};
                {4, 8, 5, 2, 25};
        nextSmallerElement(array);
    }
}
