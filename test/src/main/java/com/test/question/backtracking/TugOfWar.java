package com.test.question.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TugOfWar {
    public static List<Integer> set1 = null;
    public static List<Integer> set2 = null;

    public static int minDiff = Integer.MAX_VALUE;

    public static void tugOfWar(int[] array, int index, Deque<Integer> deque1, Deque<Integer> deque2, int sum1, int sum2) {
        int mid = (int) Math.ceil((double) array.length / 2);
        if (deque1.size() > mid || deque2.size() > mid) {
            return;
        } else if (index == array.length) {

            if (minDiff > Math.abs(sum1 - sum2)) {
                minDiff = Math.abs(sum1 - sum2);
                set1 = new ArrayList<Integer>(deque1);
                set2 = new ArrayList<Integer>(deque2);
            }
            return;
        }
        deque1.addLast(array[index]);
        tugOfWar(array, index + 1, deque1, deque2, sum1 + array[index], sum2);
        deque1.removeLast();
        deque2.addLast(array[index]);
        tugOfWar(array, index + 1, deque1, deque2, sum1, sum2 + array[index]);
        deque2.removeLast();
    }

    public static void main(String[] args) {
//        int[] given = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
        int[] given = {1, 1};
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        tugOfWar(given, 0, deque1, deque2, 0, 0);
        System.out.println(set1);
        System.out.println(set2);
    }
}
