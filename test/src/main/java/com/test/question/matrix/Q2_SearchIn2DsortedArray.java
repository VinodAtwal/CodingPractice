package com.test.question.matrix;

public class Q2_SearchIn2DsortedArray {

//   /*Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.*/

    public static Integer[] getLowerbound(Integer[][] arr,Integer k) {
        Integer low = 0, high = arr.length - 1;
        while (low <= high) {
            Integer mid = (low + high) / 2;
            if (arr[mid][0] == k) {
                return arr[mid];
            } else if (arr[mid][0] > k) {
                    if(mid-1>=0 && arr[mid-1][0]<k){
                        return arr[mid-1];
                    }
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
       return arr[arr.length-1];
    }


    public  static  void  findIn2DArray(Integer[][] arr, Integer k){
        Integer[]  array = getLowerbound(arr,k);
        if(array[0]==k){
            System.out.println("Element found");
            return;
        }else if(array[0]<k){
            Integer low = 0, high = array.length - 1,mid;
            while (low <= high){
                mid = (low+high)/2;
                if(array[mid]==k){
                    System.out.println("Element found");
                    return;
                }else if( array[mid]<k){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }

        System.out.println("Element Not Found");


    }



    public static void searchIn2DSortedArrayStandard( Integer[][] arr , Integer k){
        Integer low=0,high= arr.length-1,mid  ;

        while(low<=high){

            mid = (low+high)/2;

//            if(arr[mid][0]==k || k==arr[mid][arr[0].length-1]){
//                System.out.println("Element Exists in matrix");
//                return;
//            }else if( k> arr[mid][0] && k< arr[mid][arr[0].length-1]){
//                 binarySearch(arr[mid],k);
//                 return;
//            }else if(k<arr[mid][0]){
//                high=mid-1;
//            }else if(k> arr[mid][arr[0].length-1]){
//                low=mid+1;
//            }

            if(arr[mid][0]==k || k==arr[mid][arr[0].length-1]){
                System.out.println("Element Exists in matrix");
                return;
            }else if(k<arr[mid][0]){
                high=mid-1;
            }else if(k> arr[mid][arr[0].length-1]){
                low=mid+1;
            }else{
                binarySearch(arr[mid],k);
                return;
            }

        }
        System.out.println("Element doest not Exists in matrix");

    }

    private static void binarySearch(Integer arr[] , Integer k) {
        Integer low=0,high= arr.length-1,mid  ;

        while(low<=high) {

            mid = (low + high) / 2;

            if(arr[mid]==k){
                System.out.println("Element Exists in matrix");
                return;
            }else if(arr[mid]>k){
                high=mid-1;
            }else{
                low=mid+1;
            }


        }
        System.out.println("Element doest not Exists in matrix");
           }


    public static void main(String[] args) {
        Integer[][] arr =
//                {
//                        {1,2,3,5,6},
//                        {11,12,14,15,16},
//                        {20,21,22, 25, 28},
//                };

                {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {11,12,13},
                {14,15,16},
                {17, 18,18},
                {20,21,22},
        };

        searchIn2DSortedArrayStandard(arr,15);
       // findIn2DArray( arr, 18);
    }
}
