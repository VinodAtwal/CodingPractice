package com.test.dynamicprograming;

public class CountSubsetSum {

    public static void main(String[] args) {
        int arr[] = new int[]{ 2, 3, 6, 8, 10};
        int n = 5;
        int sum =10;
        System.out.println( countSubsetSum(arr,n,sum));
    }

    public static int countSubsetSum(int arr[], int n, int sum){
        int[][] t = new int[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            t[i][0]=1;
        }

        for (int i = 1; i <= sum; i++) {
            t[0][i]=0;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=sum; j++) {
                if(j<arr[i-1]){
                    t[i][j] = t[i-1][j];
                }else{
                    t[i][j] =t[i-1][j-arr[i-1]] + t[i-1][j];
                }
            }
        }
        return t[n][sum];

    }
}
