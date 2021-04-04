package com.test.question.array;

import com.test.Utility.Utility;

public class Q6_CyclicArrayRotation {

    public static void reverse(Integer[] arr, Integer i, Integer j){
        while(i<j){
            Utility.swap(arr,i,j);
            i++;j--;
        }
    }

    public static void main(String[] args) {
         Integer arr[] = {1,2,3,4,5,6,7,8,9};
         int k=3;
         
         reverse(arr,0, arr.length-1);
         reverse(arr,0,k-1);
         reverse(arr,k,arr.length-1);

         for (Integer i:arr) System.out.print(i +" ");
    }
}
