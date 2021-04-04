package com.test.question.array;

public class Q8_LargestSumOfSubContigiousArray {


    public static void main(String[] args) {
//        Integer arr[]={1,2,3,-2,-4,4,9};
        Integer arr[] ={-1,-2,25,-3,-4};

        Integer maxSum=Integer.MIN_VALUE;


        Integer currSum=0;
        for(Integer i : arr ){
            currSum+=i;
            maxSum=Integer.max(maxSum,currSum);
            if(currSum<0) currSum=0;
        }
        System.out.println("MaxSum: "+maxSum);


    }
}
