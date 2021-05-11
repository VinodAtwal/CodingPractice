package com.test.question.array;

public class Q14_BestTimeBuySellStock {

    public static int bestTimeToSellBuyStock(int[] arr){
        int min=arr[0],profit=0;
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else {
                profit = Math.max(profit, arr[i] - min);
            }
        }
              return profit;
    }

    public static void main(String[] args) {
        int[] arr={5,9,1,3,2};
//                {1,1,1,1,1};
//                {7,6,4,3,1};
        System.out.println(bestTimeToSellBuyStock(arr));
    }
}
