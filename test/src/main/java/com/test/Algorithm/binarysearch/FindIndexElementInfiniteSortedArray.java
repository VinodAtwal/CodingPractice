package com.test.Algorithm.binarysearch;

public class FindIndexElementInfiniteSortedArray {
    public static int findIndexInfiniteSortedArray(int[] arr, int key) {
        int low = 0;
        int high = 1;
        while (arr[high] < key) {
            low = high;
            high *= 2;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int key = 13;
        System.out.println(findIndexInfiniteSortedArray(arr, key));
    }
}
