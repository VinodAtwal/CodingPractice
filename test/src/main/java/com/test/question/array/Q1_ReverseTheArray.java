package com.test.question.array;

public class Q1_ReverseTheArray {


    public static void main(String[] args) {
        int a[] ={1,2,3,4,5,6};
        int i,j;
        i=0;
        j=a.length-1;
        while(i<j){
            a[i] =a[i]+a[j];
            a[j]=a[i]-a[j];
            a[i]=a[i]-a[j];
            i++;
            j--;
        }
        for( i =0;i<a.length;i++) System.out.println(a[i]);
    }


}
