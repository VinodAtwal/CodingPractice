package com.test.question.array;



public class Q10_MinimumNumberJumpsReachEnd {

    public static Integer MaxReachIndex(Integer arr[],Integer l,Integer range){
        System.out.println("In funtion "+l+" "+range);
        Integer maxRange=0;
        Integer maxRangeIndex=-1;
        for(int i =l+1;i<=(l+range);i++){
            if(i< arr.length){
                if(arr[i]+i >maxRange){
                    maxRange=arr[i]+i;
                    maxRangeIndex=i;
                }
            }else{
                return -1;
            }
        }
        return maxRangeIndex;
    }

    public static void minimumNumberJumpsReachEnd(Integer arr[]){

        Integer jump=0;
        Integer i=0;
        while( true) {
            if (arr[i] == 0) {
                jump = -1;
                break;
            }
            ++jump;
            i = MaxReachIndex(arr, i, arr[i]);
            if (arr.length - 1 <= arr[i] + i) {
                System.out.println(++jump);
                break;
            }

        }
        System.out.println("JUMP "+jump);
    }

    public static void main(String[] args) {
        Integer arr[]=
//                {1, 3, 2, 1, 0, 2, 6, 7, 6, 8, 9};
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
//                { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
//                {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
                  {9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        minimumNumberJumpsReachEnd(arr);
    }
}
