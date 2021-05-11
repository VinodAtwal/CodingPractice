package com.test.question.array;

import java.util.List;

public class Q12_MergeIntervals {

    public static  int partition(int [][] arr , int low,int high){
        int i=low-1,piviot=arr[high][0];

        for(int j=0;j<high;j++){
            if(arr[j][0]<piviot){
                i++;
                int[] temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int[] temp = arr[i];
        arr[i]=arr[high];
        arr[high]=temp;
        return i;
    }

    public static void quickSort(int[][] arr , int low,int high){
        if(low<high) {
            int piviot = partition(arr, low, high);
            quickSort(arr, low, piviot - 1);
            quickSort(arr, piviot + 1, high);
        }
    }

    public static void mergeInterval(int[][] arr){
        int cur[] = arr[0];
        int curri=0;
        int i=1;
        while (i<arr.length) {
                if(cur[1]>=arr[i][0]){
                    arr[curri][1]= Math.max(arr[i][1],cur[1]);
                    arr[i][0]=Integer.MAX_VALUE;
                    arr[i][1]=Integer.MAX_VALUE;
                }else{
//                    System.out.print("["+arr[curri][0]+" "+arr[curri][0]+"] " );
                    cur= arr[i];
                    curri=i;
                }

            i++;
        }
        for (int j = 0; j < arr.length ; j++) {
            if(arr[j][0]<Integer.MAX_VALUE) {
                System.out.print("["+arr[j][0]+" "+arr[j][1]+"] ");
            }
        }
    }

    public static void main(String[] args) {
//        int arr[][] ={{5 ,9},{1,3},{2,4},{6,9} };
        int arr[][] ={{1 ,3},{6,8},{4,5},{7,9} };
//        int arr[][]={{1, 3}, {2, 4}, {5, 7}, {6, 8}, {8, 12}};
        quickSort(arr,0,arr.length-1);

        mergeInterval(arr);

    }

}
