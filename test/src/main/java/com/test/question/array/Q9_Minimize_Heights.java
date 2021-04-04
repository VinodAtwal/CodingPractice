package com.test.question.array;

public class Q9_Minimize_Heights {
    public static Integer minimumHeight(Integer arr[],Integer k) {
        Integer minsameActionAll =arr[arr.length-1]-arr[0];

        Integer sml= arr[0]+k;
        Integer high= arr[arr.length-1]-k;
        if(high<sml){
            Integer temp = sml;
            sml= high;
            high= temp;
        }
        Integer minimumHeight = high-sml;
        Integer index= 1;
        while(index<arr.length-1){
            if(arr[index]+k >high && arr[index]-k<sml){                
                Integer difplusK = arr[index]+k-sml;
                Integer difsubK = high-(arr[index]-k);

                    if (difplusK < difsubK) {
                        high=arr[index]+k;
                        minimumHeight=difplusK;
                    } else {
                            sml=arr[index]-k;
                        minimumHeight=difsubK;
                    }

            }
            index++;


        }
        return Math.min(minimumHeight,minsameActionAll);
    }

    public static void main(String[] args) {
        Integer[] arr ={4,5,6,7};
        Integer k=2;
        System.out.println(minimumHeight(arr,k));
    }
}
