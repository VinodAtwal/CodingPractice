package com.test.Algorithm.binarysearch;

public class BinarySearch {

    public static int binarySearch(int arr[], int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        /*
            low always show upper bound
            high always show lower bound


            mid cant show any thing its dynamic
        * */
//        System.out.println("low " + low + " " + arr[low] + " high " + high + " " + arr[high] + " mid " + mid + " " + arr[mid]);
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 8, 9};
        binarySearch(arr, 7);
    }
}
