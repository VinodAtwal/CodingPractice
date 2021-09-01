package com.test.question.backtracking;

import java.util.*;

public class CombinationSum {

    public static List<List<Integer>> ans = new ArrayList<>();

    public static void combinationSum(int[] input, int sum, int index, Deque<Integer> currentSeq) {
        if (index >= input.length || sum < 0) {
            return;
        }
        if (sum == 0) {
            ans.add(new ArrayList<>(currentSeq));
            return;
        }

        combinationSum(input, sum, index + 1, currentSeq);

        currentSeq.addLast(input[index]);
        combinationSum(input, sum - input[index], index, currentSeq);
        currentSeq.removeLast();


    }

    public static void main(String[] args) {

//        int[] input = {7, 2, 6, 5};
//        int sum = 16;

        int[] input = {6, 5, 7, 1, 8, 2, 9, 9, 7, 7, 9};
        int sum = 6;

        Deque<Integer> seq = new ArrayDeque<>();
        Arrays.sort(input);
        combinationSum(input, sum, 0, seq);
        for (List<Integer> l : ans) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
