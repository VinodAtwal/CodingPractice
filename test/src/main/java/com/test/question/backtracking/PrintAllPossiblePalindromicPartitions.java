package com.test.question.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PrintAllPossiblePalindromicPartitions {

    public static boolean isPalindrome(String word, int start, int end) {
        while (start < end) {
            if (word.charAt(start++) != word.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void allPossiblePalindromicPartitions(String word, int start, Deque<String> deque, List<List<String>> ans) {
        if (start >= word.length()) {
            ans.add(new ArrayList<>(deque));
            return;
        }
        for (int i = start; i < word.length(); i++) {
            if (isPalindrome(word, start, i)) {
                deque.addLast(word.substring(start, i + 1));
                allPossiblePalindromicPartitions(word, i + 1, deque, ans);
                deque.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> ans = new ArrayList<>();
        Deque<String> deque = new ArrayDeque<>();
        String word = "niiitin";
        allPossiblePalindromicPartitions(word, 0, deque, ans);

        for (List<String> ls : ans) {
            for (String s : ls) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }
}
