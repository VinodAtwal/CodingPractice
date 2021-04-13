package com.test.question.stackandqueue;

import java.util.Stack;

public class Q4_Celebrityproblem {
    // when celeb always exsist
    public  static Integer findCeleb(Integer[][] arr){
        Integer m=null;
        for(int i= 0 ; i< arr.length;i++){
            if(m==null){
                m=i;
                continue;
            }
            System.out.println(m+" "+i+" ");
            if(arr[m][i]==1 && arr[i][m]==0){
                m=i;
            }else if ((arr[m][i]==1 && arr[i][m]==1) || (arr[m][i]==0 && arr[i][m]==0) ){
                m=null;
            }
            System.out.print(m+" ");
        }

        return m==null? -1 :m;
    }

    public static void main(String[] args) {
        Integer arr[][]=
                { {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0} };

//                        { {0, 0, 1, 0},
//                        {0, 0, 1, 0},
//                        {0, 0, 0, 0},
//                        {0, 0, 1, 0} };
//                {{0,1},{1,0}};
//                {{0,1,0},
//                {0,0,0},
//                {0,1,0}};
        System.out.println();
        System.out.println(findCeleb(arr));


    }
}
