package com.test.Algorithm.binarysearch;

public class BinarySearchInReverseArray {

    public static int binarySearchInReverseArray(int[] decArr, int key) {
        int low = 0;
        int high = decArr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (decArr[mid] == key) {
                return mid;
            } else if (decArr[mid] < key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(binarySearchInReverseArray(arr, 5));
    }

}
