package com.test.question.backtracking;

import java.util.HashSet;

public class RemoveInvalidParentheses {

    public static int countInvalidParentheses(String s) {
        int unbalance = 0;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                rightCount++;
            }
            if (leftCount == rightCount) {
                leftCount = rightCount = 0;
            } else if (rightCount > leftCount) {
                unbalance++;
                leftCount = rightCount = 0;
            }
        }
        unbalance += leftCount;
        return unbalance;
    }

    public static void removeInvalidParentheses(String s, HashSet<String> ans, int allowedRemoval, int index) {
        if (allowedRemoval == 0) {
            if (countInvalidParentheses(s) == 0 && !ans.contains(s)) {
                ans.add(s);
                System.out.println(s);

            }
            return;
        }
        if (index < s.length()) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                removeInvalidParentheses(s.substring(0, index) + s.substring((index + 1)), ans, allowedRemoval - 1, index);
            }
            removeInvalidParentheses(s, ans, allowedRemoval, index + 1);
        }
    }

    public static void removeInvalidParenthesesOptimize(String s, HashSet<String> ans, int allowedRemoval) {
        if (allowedRemoval == 0) {
            if (countInvalidParentheses(s) == 0 && !ans.contains(s)) {
                ans.add(s);
                System.out.println(s);

            }
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                removeInvalidParenthesesOptimize(s.substring(0, i) + s.substring((i + 1)), ans, allowedRemoval - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "(a)())))())(";
        //"(a)())()";
        //")(";
//                "()())()";

        removeInvalidParentheses(s, new HashSet<String>(), countInvalidParentheses(s), 0);

//        removeInvalidParenthesesOptimize(s, new HashSet<String>(), countInvalidParentheses(s));
    }


}
