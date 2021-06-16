package com.test.question.searchandsort;

public class Q5_SearchingArrayWhereAdjacentDifferByAtMostK {

    public static int searchingArrayWhereAdjacentDifferByAtMostK(int[] arr, int k, int key) {
        int index = 0;
        while (index < arr.length) {
            if (arr[index] == key) {
                return index;
            }
            index = index + Math.max(1, (int) Math.abs(arr[index] - key) / k);
        }
        return -1;
    }

    public static void main(String[] args) {
//        int arr[] = {4, 5, 6, 7, 6};
//        int k = 1;
//        int x = 6;
        int arr[] = {20, 40, 50, 70, 70, 60};
        int k = 20;
        int x = 60;
        System.out.println(searchingArrayWhereAdjacentDifferByAtMostK(arr, k, x));
    }
}
