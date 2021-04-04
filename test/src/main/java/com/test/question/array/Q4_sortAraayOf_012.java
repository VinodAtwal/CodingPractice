package com.test.question.array;

import com.test.Utility.Utility;

public class Q4_sortAraayOf_012 {

    public static void sort012(Integer arr[]){
        Integer l=0,m=0,h=arr.length-1,index=0;

        while(m<h){
            switch (arr[m]){
                case 0:{
                    Utility.swap(arr,l,m);
                    l++;
                    m++;
                    break;
                }
                case 1:{
                    m++;
                    break;
                }
                case 2:{
                    Utility.swap(arr,m,h);
                    h--;
                    break;
                }
            }
        }

    }

    public static void soert01(Integer arr[]){
        Integer l=0,m=0;
        while(m<arr.length){
            switch (arr[m]){
                case 0:{
                    l++;

                }

                }
                m++;
            }

        }


    public static void main(String[] args) {

        Integer[] arr012= {0, 0, 1, 1, 2, 0, 2, 1, 0, 2, 1, 1, 2, 0};
        Integer[] arr01= {0, 0, 1, 1,  0,  1, 0,  1, 1,  0};
        sort012(arr012);
        soert01(arr01);
        for(Integer i: arr01){
            System.out.print(i+" ");
        }


    }
}
