package com.test.Algorithm.binarysearch;

public class FirstOrLastOccurrenceInSortedArray {

    public static int firstOccurrence(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                res = mid;
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public static int lastOccurrence(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                res = mid;
                low = mid + 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4, 5, 6, 7};
        System.out.println(firstOccurrence(arr, 4));
        System.out.println(lastOccurrence(arr, 4));
    }
}
