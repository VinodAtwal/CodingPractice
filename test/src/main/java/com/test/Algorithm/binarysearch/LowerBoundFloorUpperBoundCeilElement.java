package com.test.Algorithm.binarysearch;

public class LowerBoundFloorUpperBoundCeilElement {
    public static int binarySearchFloor(int arr[], int key) {
        int res = -1;
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == key) {
                high = mid - 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                res = mid;
                low = mid + 1;
            }
        }
        return res;
    }
    

    public static int binarySearchLowerThanGivenElement(int arr[], int key) {
        int res = -1;
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] >= key) {
                high = mid - 1;
            } else {
                res = mid;
                low = mid + 1;
            }
        }
        return res;
    }

    public static int binarySearchCeil(int arr[], int key) {
        int res = -1;
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == key) {
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;

            }
        }
        return res;
    }

    public static int binarySearchGreaterThanGivenElement(int arr[], int key) {
        int res = -1;
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }

    public static void lowerBoundUpperBoundElementNotExist(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }


        /*    if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }*/
        }
        low = low > -1 && low < arr.length ? arr[low] : -1;
        high = high > -1 && high < arr.length ? arr[high] : -1;
        System.out.println("LowerBound " + low + " upperBound " + high);

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5, 5, 8, 9};
        int key = 5;
//        System.out.println(binarySearchFloor(arr, key));
//        System.out.println(binarySearchLowerThanGivenElement(arr, key));
//        System.out.println(binarySearchCeil(arr, key));
//        System.out.println(binarySearchGreaterThanGivenElement(arr, key));
//        lowerBoundUpperBoundElementNotExist(arr, key);


    }

}
