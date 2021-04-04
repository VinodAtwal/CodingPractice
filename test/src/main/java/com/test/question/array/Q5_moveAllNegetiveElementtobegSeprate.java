package com.test.question.array;

import com.test.Utility.Utility;

public class Q5_moveAllNegetiveElementtobegSeprate {

    public static void moveNegetiveValue(Integer[] arr){
        int negIndex = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] < 0) {
                Utility.swap(arr, negIndex, j);
                negIndex++;
            }
            j++;
        }
    }

    public static void moveNegetiveByPatition(Integer[] arr){
        int high= arr.length-1, low=0;

        while (low < high) {
            if (arr[low] >= 0 && arr[high] < 0) {
                Utility.swap(arr, low, high);
                low++;
                high--;
            } else if (arr[low] >= 0 && arr[high] >=0) {
                high--;
            }else if (arr[low] < 0 && arr[high] < 0) {
                low++;
            }else{
                low++;
                high++;
            }
        }

    }


    public static void main(String[] args) {
        Integer arr[] ={ 1,-1,2,3,-2,-5,0,1};
//        moveNegetiveValue(arr);
        moveNegetiveByPatition(arr);
        for(Integer i: arr){
            System.out.print(i+" ");
        }
    }
}
