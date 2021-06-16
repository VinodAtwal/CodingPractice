package com.test.Algorithm.binarysearch;

public class NumberOfTimesSortedArrayRotated {
    public static int numberOfTimeSortedArrayRotated(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        int prev = -1;
        int next = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            prev = (mid + arr.length - 1) % arr.length;
            next = (mid + 1) % arr.length;
            // should put high= mid -1 at before low =mid+1 other wise it will make start = mid+1 for non rotated array
            if (arr[prev] > arr[mid] && arr[next] > arr[mid]) {
                return mid;
            } else if (arr[mid] < arr[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

           /* else if (arr[mid] > arr[low]) {
                low = mid + 1;  cant use  it other wise it will broke desc order array
            }*/

        }
        return -1;
    }

    public static int numberOfTimeSortedArraySurelyRotated(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        int prev = -1;
        int next = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            prev = (mid + arr.length - 1) % arr.length;
            next = (mid + 1) % arr.length;
            // should put high= mid -1 at before low =mid+1 other wise it will make start = mid+1 for non rotated array
            if (arr[prev] > arr[mid] && arr[next] > arr[mid]) {
                return mid;
            } else if (arr[mid] < arr[high]) {
                high = mid - 1;
            } else if (arr[mid] > arr[low]) {
                low = mid + 1;
            }

           /* else if (arr[mid] > arr[low]) {
                low = mid + 1;  cant use  it other wise it will broke desc order array
            }*/

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr1 = {6, 7, 1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println(numberOfTimeSortedArrayRotated(arr2));
    }
}
