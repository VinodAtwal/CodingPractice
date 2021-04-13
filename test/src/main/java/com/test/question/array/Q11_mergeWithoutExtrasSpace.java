package com.test.question.array;

import com.test.Utility.Utility;

import java.util.Arrays;

public class Q11_mergeWithoutExtrasSpace {

    public static Pair<Integer[]> MergeWithoutExtraSPaceComplexhightimetaking(Integer arr1[],Integer arr2[]) {


        return new Pair<>(arr1,arr2);
    }

    public static Pair<Integer[]> MergeWithoutExtraSPaceSimple(Integer arr1[],Integer arr2[]){
        Integer i=0,j=0,k=arr1.length-1;
        while(i<=k && j<=arr2.length-1){
            if(arr1[i]>arr2[j]){
                Integer temp= arr1[k];
                arr1[k]=arr2[j];
                arr2[j]=temp;
                k--;
                j++;
            }else{
                i++;
            }

//            Utility.printArrary(arr1);
//            System.out.println("");
//            Utility.printArrary(arr2);
//            System.out.println("");
//            System.out.println("");
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return new Pair<>(arr1,arr2);
    }

    public static void main(String[] args) {
        Integer arr1[]={0, 2, 6, 8, 9};
        Integer arr2[]={1, 3, 5, 7};
        MergeWithoutExtraSPaceSimple(arr1,arr2);
        Utility.printArrary(arr1);
        System.out.println("");
        Utility.printArrary(arr2);




    }
}
