package com.test.Algorithm;

public class MergeSort {

    public static void mergeSort(int[] arr, int low, int high) {
        if (high > low) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }

    }

    private static void merge(int[] arr, int low, int mid, int high) {

        int sizeArr1 = mid - low + 1;
        int sizeArr2 = high - mid;

        int[] leftArray = new int[sizeArr1];
        int[] rightArray = new int[sizeArr2];

        for (int i = 0; i < sizeArr1; i++) {
            leftArray[i] = arr[low + i];
        }
        for (int i = 0; i < sizeArr2; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }

        int i, j;
        i = j = 0;
        int k = low;
        while (i < sizeArr1 && j < sizeArr2) {
            if (leftArray[i] < rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }


        while (i < sizeArr1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < sizeArr2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }

    }
}
