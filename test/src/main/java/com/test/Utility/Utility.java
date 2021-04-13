package com.test.Utility;

public class Utility {
    public static <T>  void  swap ( T[] arr, T a, T b){
        T temp =arr[(int) a];
        arr[(int) a]=arr[(int) b];
        arr[(int) b]=temp;
    }
    public static <T> void printArrary(T[] arr){
        for(T a: arr){
            System.out.print(a+" ");
        }
    }
}
