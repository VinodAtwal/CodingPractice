package com.test.question.stackandqueue;

import java.util.Stack;

public class Q4_Celebrityproblem {


    public static Integer findCelebStandard(Integer[][] arr){
        Integer start = 0;
        Integer end = arr.length-1;

        Integer count=0;

        while(start<end){
            if(arr[start][end]==1 && arr[end][start]==0){
                start++;
            }else{
                end--;
            }
        }
        for (int i =0; i<arr.length;i++){
            if((arr[i][start]==0 || arr[start][i]==1) && i!=start) return -1;
        }

        return  start;


    }

    public static void main(String[] args) {
        Integer arr[][]=
//                { {0, 0, 1, 0},
//                {0, 0, 1, 0},
//                {0, 1, 0, 0},
//                {0, 0, 1, 0} };

                        { {0, 0, 1, 0},
                        {0, 0, 1, 0},
                        {0, 0, 0, 0},
                        {0, 0, 1, 0} };
//                {{0,1},{1,0}};
//                {{0,1,0},
//                {0,0,0},
//                {0,1,0}};

        System.out.println(findCelebStandard(arr));


    }
}
