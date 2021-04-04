package com.test.question.array;

public class Q7_UnionandIntersectionOfArray {

    public static void main(String[] args) {
        int arr1[] = {1,1,3,6,9,9,9,9,9,9};
        int arr2[]=  {2,2,4,6,7,9,9,9,9};

        int i=0,j=0;
        System.out.println("==Uninon==");
        while(i< arr1.length && j< arr2.length){
            if(arr1[i]<arr2[j]){
                    if(i==0 ||(i>0 && arr1[i-1]!=arr1[i])) {
                        System.out.print(arr1[i] + " ");
                    }
                i++;
            }else if(arr1[i]>arr2[j]){
                if(j==0 ||(j>0 && arr2[j-1]!=arr2[j])) {
                    System.out.print(arr2[j] + " ");
                }
                j++;
            }else{
                if((i==0 && j==0) ||((j>0 && arr2[j-1]!=arr2[j]) || (i>0 && arr1[i-1]!=arr1[i]))) {
                    System.out.print(arr1[i] + " ");
                }
                i++;
                j++;
            }
        }
        if(i!= arr1.length-1){
            for(;i<arr1.length;i++) {
                if(i==0 ||(i>0 && arr1[i-1]!=arr1[i])) {
                    System.out.print(arr1[i] + " ");
                }
            }
        }else if(j!= arr2.length-1){
            for(;j<arr2.length;j++) {
                if(j==0 ||(j>0 && arr2[j-1]!=arr2[j])) {
                    System.out.print(arr1[j] + " ");
                }
            }
        }
        System.out.println("");
        System.out.println("==Intersection==");

         i=0;j=0;
        while(i< arr1.length && j< arr2.length){
            if(arr1[i]==arr2[j]){
                if((i==0 && j==0) ||((j>0 && arr2[j-1]!=arr2[j]) || (i>0 && arr1[i-1]!=arr1[i]))) {
                    System.out.print(arr1[i] + " ");
                }

            }
            i++;j++;
        }
    }
}
