package com.test.question.array;

import java.util.Arrays;
import java.util.HashMap;

public class Q15_CountPairsGivenSum {
    public static int countPairGivenSum(int[] arr, int n){
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        Arrays.stream(arr).forEach(i->{
            hashMap.putIfAbsent(i,0);
            hashMap.put(i,hashMap.get(i)+1);
        });

        int count=0;
        for (int i = 0; i < arr.length; i++) {
            //valCount can be null
            Integer valCount= hashMap.get(n-arr[i]);

            if(valCount!=null && valCount>0){
                if(n-arr[i]==arr[i] && valCount>=1){
                    count+= valCount-1;
                    hashMap.put(arr[i],0);
//                    continue;
                }else {
                    count += valCount;
                    hashMap.put(arr[i], hashMap.get(arr[i]) - 1);
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
//        int arr[] = { 22, 14, 22, 30,23, 30, 6, 17, 40,  32, 13, 4,40, 61, 49, 2, 23, 17, 28,
//                30, 41, 2, 18};
        int arr[] = {48, 24, 33, 39, 29, 22, 46, 40, 37,26, 28, 10,25 ,  47, 34,  26, 49
                , 36,  5, 26, 4, 39,  27, 12, 15, 3};
//        int arr[]= {2, 5, 7, 1, 8, 0, 1, 7};
//                {1, 5, 7, 1};
        int sum=8;
        System.out.println(countPairGivenSum(arr,50));
    }
}
