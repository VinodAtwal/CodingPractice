package com.test.question.stackandqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class Q16_InterleaveFirstHalfOfTheQueueWithSecondHalf {
    public static void interleaveFirstHalfOfTheQueueWithSecondHalf(Queue<Integer> queue) {
        int length = queue.size();
        int mid = queue.size() / 2;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < mid; i++) {
            stack.push(queue.poll());
        }
        System.out.println();
        System.out.println("stack " + stack);
        System.out.println("queue " + queue);

        for (int i = 0; i < mid; i++) {
            queue.add(stack.pop());
        }
        System.out.println();
        System.out.println("stack " + stack);
        System.out.println("queue " + queue);

        for (int i = 0; i < length - mid; i++) {
            queue.add(queue.poll());
        }
        System.out.println();
        System.out.println("stack " + stack);
        System.out.println("queue " + queue);

        for (int i = 0; i < mid; i++) {
            stack.push(queue.poll());
        }
        System.out.println();
        System.out.println("stack " + stack);
        System.out.println("queue " + queue);
        for (int i = 0; i < mid; i++) {
            System.out.print(stack.pop() + " " + queue.poll() + " ");
        }
        if (!queue.isEmpty()) {
            System.out.print(queue.poll());
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Queue<Integer> queue = Arrays.stream(arr).boxed().collect(Collectors.toCollection(LinkedList::new));
        interleaveFirstHalfOfTheQueueWithSecondHalf(queue);
    }
}
