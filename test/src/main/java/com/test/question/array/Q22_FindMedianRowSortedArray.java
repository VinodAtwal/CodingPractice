package com.test.question.array;


import java.util.Arrays;

//Assume R*C always Odd
public class Q22_FindMedianRowSortedArray {

    public static int medianInRowSortedArrays(int[][] arr){
        int row= arr.length;
        int col= arr[0].length;
        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        //setting up max and min values
        for (int i = 0; i < row; i++) {
            min= Math.min(min, arr[i][0]);
            max=Math.max(max,arr[i][col-1]);
        }
        int desiredNthValue= ((row*col)+1)/2;

        int low= min;
        int high=max;



        while (low<high){
            int smallerElement=0;
            int totalSmallElementAccToMid=0;
            int mid = (low+high)/2;

            for (int i = 0; i <row ; i++) {

                smallerElement= Arrays.binarySearch(arr[i],mid);
                if(smallerElement<0){
                    smallerElement=Math.abs(smallerElement)-1;
                }else{
                    // taking upper bound
                    //while(smallerElement+1<col && arr[i][++smallerElement]==mid ){}
                    //while(++smallerElement<col && arr[i][smallerElement]==mid ){}
                    while(smallerElement<col && arr[i][smallerElement]==mid ) {
                        ++smallerElement;
                    }
                }
                totalSmallElementAccToMid+=smallerElement;
                }

                if(desiredNthValue>totalSmallElementAccToMid){
                    low=mid+1;
                }else{
                    high=mid;
                }
        }

    return low;
    }

    public static void main(String[] args) {
        int m[][]= { {1,9,9}, {2,9,9}, {3,6,9} };

        System.out.println(medianInRowSortedArrays(m));
    }
}
