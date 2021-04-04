package com.test.question.array;

public class Q11_MergeWithoutExtraSpace {

    static void setValueByVirtualIndex(Integer arr1[], Integer arr2[],Integer virtualIndex,Integer value ){
        Integer na1=arr1.length;
        Integer na2= arr2.length;
        if (virtualIndex> arr1.length-1) {
            arr2[virtualIndex - arr1.length - 1] = value;
        }else{
            arr1[virtualIndex]=value;
        }


    }

    static Integer getValueBYVirtualIndex(Integer arr1[], Integer arr2[],Integer virtualIndex){
        if (virtualIndex> arr1.length-1) {
            return arr2[virtualIndex - arr1.length - 1] ;
        }else{
            return arr1[virtualIndex];
        }
    }
    static Integer getIndexBYVirtualIndex(Integer arr1[], Integer arr2[],Integer virtualIndex){
        if (virtualIndex> arr1.length-1) {
            return virtualIndex - arr1.length - 1;
        }else{
            return virtualIndex;
        }
    }

    public static void main(String[] args) {
        Integer arr1[] ={1, 3, 5, 7};
        Integer arr2[] ={0, 2, 6, 8, 9};


    }
}
