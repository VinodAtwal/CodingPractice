package com.test.question.array;

import java.util.HashSet;
import java.util.Set;

public class Q16_CommonElements {

    public static Set<Integer> commonElement(int[] arr1, int[] arr2, int[] arr3){
        int i=0,j=0,k=0;
        Set<Integer> set = new HashSet<>();
        while(i<arr1.length && j<arr2.length && k<arr3.length){
            if(arr1[i]==arr2[j] && arr2[j]==arr3[k]){
                set.add(arr1[i]);
                i++;
                j++;
                k++;
                continue;
            }
            if(arr1[i]<= arr2[j]  && arr1[i]<=arr3[k]){
                i++;
            }else if(arr2[j]<=arr1[i] && arr2[j]<=arr3[k]){
                j++;
            }else{
                k++;
            }
        }
        return set;
    }

    public static void main(String[] args) {
        int[] arr1={1, 5, 10, 20, 40, 80};
        int[] arr2={6, 7, 20, 80, 100};
        int[] arr3={3, 4, 15, 20, 30, 70, 80, 120};
//        int[] arr1={1, 5, 10, 20, 40, 80};
//        int[] arr2={1, 5, 10, 20, 40, 80};
//        int[] arr3={1, 5, 10, 20, 40, 80};

        commonElement(arr1,arr2,arr3).forEach(System.out::println);

    }
}
