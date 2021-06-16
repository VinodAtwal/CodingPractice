package com.test.question.searchandsort;

import java.util.Arrays;

public class Q6_FindPairWithGivenDifference {

    public static void findPairWithGivenDifference(int[] arr, int dif) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int index = Arrays.binarySearch(arr, i + 1, arr.length, arr[i] + dif);
            if (index >= 0) {
                System.out.println(arr[i] + " " + arr[index]);
                return;
            }
        }
    }

    public static void main(String[] args) {
//        int arr[] = {5, 20, 3, 2, 50, 80}, n = 78;
        int arr[] = {90, 70, 20, 80, 50}, n = 10;
        findPairWithGivenDifference(arr, n);
    }
}
