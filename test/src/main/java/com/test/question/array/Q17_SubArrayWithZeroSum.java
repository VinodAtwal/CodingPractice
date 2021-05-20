package com.test.question.array;

import java.util.Arrays;
import java.util.HashSet;

public class Q17_SubArrayWithZeroSum {

    public static boolean subArrayWithZeroSum(int arr[]){
        HashSet<Integer> hashSet= new HashSet<>();
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
            if(hashSet.contains(sum)){return true;}
            hashSet.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[]={4, 2, -3, 1, 6};
              //  {-3, 2, 3, 1, 6};
        System.out.println(subArrayWithZeroSum(arr));
    }

}
