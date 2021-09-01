package com.test.question.binarysearchtree;

public class Q9_LargestBST {

    static class nodeDetails {
        int size, max, min, ans;
        boolean isBST;

        public nodeDetails(int size, int max, int min, int ans, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.ans = ans;
            this.isBST = isBST;
        }
    }
}
