package com.test.question.searchandsort;

public class Q2_SearchRotatedSortedArray {

    public static int noOfRotation(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int n = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            // treat as a circular array
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;
            System.out.println(low + "," + mid + "," + high + " " + arr[prev] + " " + arr[mid] + " " + arr[next] + " low " + arr[low] + " high " + arr[high]);
            if (arr[prev] > arr[mid] && arr[mid] < arr[next]) {
                return mid;
            } else if (arr[mid] < arr[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] =
//                {1, 0};
                {4, 3, 2, 1, 0};
//                {0, 1, 2, 3, 4};
        System.out.println(noOfRotation(arr));
    }
}
