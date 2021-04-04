package com.test.question.searchandsort;

public class Q2_SearchRotatedSortedArray {

    public static Integer getRoatedArrayStartIndex(Integer arr[]){
        Integer l=0,h=arr.length-1;
        while(l<=h){
            Integer mid= (l+h)/2;
            System.out.println(mid);
            if(mid>0 && mid<arr[arr.length-1] && arr[mid-1]>arr[mid] && arr[mid] <arr[mid+1] ) {
                return mid;

            }else{
                if(arr[0]>arr[mid] && !(arr[mid-1]>arr[mid])){
                    h=mid-1;
                }else{
                    l=mid+1;
                }
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        Integer arr[]=
                //{  5,0,1,2,3,4};
                //{5,4,3,2,1,0};
                //{0,1,2,4,5,6,7};
                {4,5,6,7,0,1,2};

        System.out.println(getRoatedArrayStartIndex(arr));


    }
}
