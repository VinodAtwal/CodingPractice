package com.test.question.searchandsort;

public class Q1_FirstLastOccurrencesSortedArr {

    public static Integer minIndex =Integer.MAX_VALUE;
    public static Integer maxIndex =Integer.MIN_VALUE;

    public static void firstlastOccurence(Integer arr[],Integer val,Integer l,Integer h) {
        Integer  mid=(l+h)/2;
        if(l<=h){
            if(val>arr[mid]){
                firstlastOccurence(arr,val,mid+1,h);
            }else if(val<arr[mid]){
                firstlastOccurence(arr,val,l,mid-1);
            }else{
                if((mid-1>=0 && arr[mid-1] !=val) || mid==0 ){
                    minIndex= mid;
                }else if((mid-1>=0 && arr[mid-1] ==val) ){
                    firstlastOccurence(arr,val,l,mid-1);
                }
                if((mid+1<arr.length && arr[mid+1] !=val) || mid==arr.length-1){
                    maxIndex= mid;
                }else if(mid+1<arr.length && arr[mid+1] ==val){
                    firstlastOccurence(arr,val,mid+1,h);
                }

            }
        }



    }

    public static void main(String[] args) {

        Integer arr[] ={4,5,5,5,5,5,5};
                //{1, 3, 5, 5, 5, 5, 67, 123, 125};
        firstlastOccurence(arr,4,0,arr.length-1);
        System.out.println(minIndex+" "+maxIndex);

    }
}
