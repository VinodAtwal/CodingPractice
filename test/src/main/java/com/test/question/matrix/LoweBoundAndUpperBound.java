package com.test.question.matrix;

public class LoweBoundAndUpperBound {

    public static Integer lowerBound(Integer arr[], Integer k){
        Integer  low=0,high=arr.length-1,mid=null;
        if(k< arr[0]) {return  -1;}

        while (low<=high ){
            mid= (low+high)/2;
            if(k>arr[mid]  ){
                 low=mid;
            }else if(k== arr[mid]){
                high= mid;
            }else{
                high=mid-1;
            }
        }

        return mid!=null? arr[mid]:mid;
    }


    public static Integer upperBound(Integer arr[], Integer k){
        Integer  low=0,high=arr.length-1,mid=null;
        if(k< arr[0]) {return  -1;}
        if(k> arr[arr.length-1]) {
            return -1;
        }
        while (low<=high){
            mid= (low+high)/2;
            if(k<arr[mid]){
                low=mid;
            }else{
                high= mid-1;
            }
        }
        return mid!=null? arr[mid]:mid;
    }

    public static void main(String[] args) {
        Integer arr[] ={ 1 ,2 , 3 ,4 ,6 ,7 ,8 ,9};
        System.out.println(lowerBound(arr,7));
    }

}
