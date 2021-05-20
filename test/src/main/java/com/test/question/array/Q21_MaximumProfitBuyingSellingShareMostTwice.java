package com.test.question.array;

public class Q21_MaximumProfitBuyingSellingShareMostTwice {

    public static int maximumProfitBuyingSellingShareMostTwice(int[] arr){
       int[] profit= new int[arr.length];
       //right to left max adding
        profit[profit.length-1]=0;
        int max= arr[arr.length-1];
        for (int i = arr.length-2; i>=0 ; i--) {
            if(arr[i]>max){
                max= arr[i];
            }
            profit[i]=Math.max(profit[i+1],max-arr[i]);
        }
        int min=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<min){
                min=arr[i];
            }
            profit[i]= Math.max(profit[i-1],profit[i]+arr[i]-min);
        }

        return profit[profit.length-1];
    }

    public static void main(String[] args) {
        int[] arr={2, 30, 15, 10, 8, 25, 80};
                //{10, 22, 5, 75, 65, 60, 80, 75, 90, 110, 1, 95 };


     //   System.out.println(maximumProfitBuyingSellingShareMostTwice(arr));


    }

}
