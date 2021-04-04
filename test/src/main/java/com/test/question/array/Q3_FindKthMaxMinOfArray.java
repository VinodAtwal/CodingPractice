package com.test.question.array;

import com.test.Utility.Utility;

public class Q3_FindKthMaxMinOfArray {

    public static void quickSelect(Integer arr[]) {
        Integer i, j, l, h, piviot,k;
        i = -1;
        j = 0;
        l = 0;
        k=3;
        h = arr.length - 1;
        piviot=h;
        do {
            j=l;
            i=j-1;
            piviot=h;
            while (j < h) {
                if (arr[j] < arr[piviot]) {
                    Utility.swap(arr, ++i, j);
                }
                ++j;
            }
            if (i + 1 == piviot) {
                System.out.println("Partiton is sorted");
                break;
            } else {
                Utility.swap(arr, ++i, piviot);
            }
            if(piviot<arr.length-k){
                l=piviot+1;
            }else if(piviot>arr.length-k){
                h=piviot-1;
            }

        }while(k!= arr.length-piviot);
        System.out.println(piviot+" "+arr[piviot] );
    }


    public static void main(String[] args) {

        Integer arr[]={1,5,3,0,6,7,8};
        quickSelect(arr);


//        Boolean swap =false;
//        for(Integer i=0;i<3;i++){
//            swap=false;
//            for(Integer j=0;j<arr.length-i-1;j++) {
//
//                if (arr[j] > arr[j + 1]) {
//                    swap=true;
//                    Utility.swap(arr,j, j + 1);
//                }
//            }
//            if(!swap) break;
//        }
//        System.out.println(arr[arr.length-3]);



    }
}
