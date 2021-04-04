package com.test.question.array;

public class Q2_Max_MIN_inArray {

    public static void main(String[] args) {
        Integer a[]= {4,3,1,0,7,-1,10,8};
        Integer minVal ;
        Integer maxVal ;
        Integer index;


        if(a.length%2==0) {
            minVal = a[0];
            maxVal = a[1];
            index = 2;

        }else{
            minVal=a[0];
            maxVal=a[0];
            index=1;
        }
        for( ;index<a.length-1;index=index+2){
            if(a[index]<a[index+1]){
                if(a[index]<minVal){
                    minVal=a[index];
                }
                if(a[index+1]>maxVal){
                    maxVal=a[index+1];
                }
            }else{
                if(a[index+1]<minVal){
                    minVal=a[index+1];
                }
                if(a[index]>maxVal){
                    maxVal=a[index];
                }
            }
        }


        System.out.println(minVal);
        System.out.println(maxVal);
    }
}
