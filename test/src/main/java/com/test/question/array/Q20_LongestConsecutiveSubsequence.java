package com.test.question.array;

import java.util.Arrays;
import java.util.HashSet;

public class Q20_LongestConsecutiveSubsequence {

    public static int longestConsecutiveSubsequence(Integer[] arr){
        HashSet<Integer> hashSet = new HashSet(Arrays.asList(arr));
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            if(!hashSet.contains(arr[i]-1)){
                int count=1;
                while(hashSet.contains(arr[i]+count)){
                    count++;
                }
                max= Math.max(max,count);
            }

        }
        return max;

    }

    public static void main(String[] args) {
        Integer[] arr={2,6,1,9,4,5,3};
        System.out.println(longestConsecutiveSubsequence(arr));
    }
}
