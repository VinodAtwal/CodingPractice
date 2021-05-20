package com.test.question.array;

public class Q18_FactorialLargeNumber {

    public static int   multiply (int arr[],int value, int startind){
        int carry=0;
        for (int i = 0; i <=startind ; i++) {
            int zerothDigit= arr[i]*value;
            arr[i]=(zerothDigit+carry) %10;
            carry=(zerothDigit+carry)/10;
        }
        while (carry>0){
            arr[++startind]=carry%10;
            carry=carry/10;
        }
        return startind;
    }

    public static int factorial(int n,int[] arr){
        arr[0]=1;
        int startind=0;
        for(int i=2;i<=n;i++){
            startind = multiply(arr,i,startind);
        }
        return startind;
    }

    public static void main(String[] args) {
        int[] arr= new int[500];
        int n= 100;
        int startInd = factorial(n,arr);
        for (int i = startInd; i >=0 ; i--) {
            System.out.print(arr[i]);
        }
    }
}
