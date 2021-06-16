package com.test.question.searchandsort;

public class Q4_MajorityElement {
    public static void majorityElement(int[] arr) {
        int maxEle = arr[0];
        int maxCount = 0;
        for (int i : arr) {
            if (maxCount == 0) {
                maxEle = i;
                maxCount = 1;
                continue;
            }
            if (i == maxEle) {
                maxCount++;
            } else {
                maxCount--;
            }
        }

        maxCount = 0;
        for (int i : arr) {
            if (i == maxEle) {
                ++maxCount;
            }
        }
        if (maxCount > arr.length / 2) {
            System.out.println("majority element " + maxEle);
        } else {
            System.out.println("majority element not exsits");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 3, 2};
        majorityElement(arr);
    }
}
