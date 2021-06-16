package com.test.question.searchandsort;

public class Q3_FindRepeatingAndMissing {

    public static void findRepeatingAndMissingVisited(int[] arr) {
        int sum = 0;
        int repeating = -1;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.abs(arr[i]);
            if (arr[Math.abs(arr[i]) - 1] < 0) {
                repeating = Math.abs(arr[i]);
            } else {
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
            }
        }
        int missing = -1;
        /* index is positive means its not there in array
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0){
                missing = i+1;
            }
        }*/
        int maxSum = (arr.length * (arr.length + 1)) / 2;
        missing = maxSum - (sum - repeating);
        System.out.println("repeating " + repeating + " missing " + missing);
    }

    public static void findRepeatingAndMissingSumProductEquations(int[] arr) {
        /*Get the sum of all numbers using formula S = n(n+1)/2 – x + y
        Get product of all numbers using formula P = 1*2*3*…*n * y / x*/
        int sum = 0;
        int product = 1;
        int maxProduct = 1;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            product *= arr[i];
            maxProduct *= (i + 1);
            maxSum += (i + 1);
        }
        //  maxSum = sum- rep +miss
        //   maxSum- sum = miss - rep
        //    maxProduct = (product/rep)*miss
        //  maxProduct/product = miss/rep

        int rep = (((maxSum - sum) * product) / (maxProduct - product));
        int miss = (maxSum - sum) + rep;
        System.out.println("repeating " + rep + " missing " + miss);

    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 3, 3};
        findRepeatingAndMissingVisited(arr);
//        findRepeatingAndMissingSumProductEquations(arr);
    }
}
