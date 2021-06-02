package com.test.question.string;

public class Q6_WordWrap {

    public static int minTotalCost=Integer.MAX_VALUE;

    public static void minWordWrapCost(int[] arr, int limit,int index,int cost){
        int sum=0;
        for (int i = index; i <arr.length ; i++) {
            int currCost=0;
            sum += arr[i] ;
            if(sum+(i-index)>limit){// i-index count spaces between words
                break;
            }
            if(i == arr.length-1){
                currCost=i-index; // i-index count spaces between words
                minTotalCost=Math.min(minTotalCost,cost+currCost);
                return;
            }else {
                currCost = limit - sum ;
            }
            minWordWrapCost(arr,limit,i+1,cost+currCost);
        }
    }

    public static void main(String[] args) {
        int[] arr={3,2,2,5};
        int k=6;
        minWordWrapCost(arr,k,0,0);
        System.out.println(minTotalCost);
    }

}
