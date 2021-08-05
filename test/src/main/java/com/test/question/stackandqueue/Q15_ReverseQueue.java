package com.test.question.stackandqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Q15_ReverseQueue {

    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int val = queue.poll();
        reverseQueue(queue);
        queue.add(val);
        return;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Queue<Integer> queue = Arrays.stream(arr).boxed().collect(Collectors.toCollection(LinkedList::new));
        reverseQueue(queue);

    }

}
