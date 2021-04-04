package com.test.question.array;

//todo
//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
public class Q11_FindDuplicateNumber {

    public static Integer findDuplicateNumber(Integer arr[] ){
        Integer range= arr.length-1;
        Integer maxSum = (range*(range+1))/2;
        Integer sum=0;
        for(Integer i:arr){
            sum+=i;
        }
        return sum-maxSum;
    }

    public static void main(String[] args) {
        Integer  arr[] ={1,3,4,2,2};
        System.out.println(findDuplicateNumber(arr));
    }
}
