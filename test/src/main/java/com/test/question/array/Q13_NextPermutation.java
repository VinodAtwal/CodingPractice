package com.test.question.array;

import java.util.ArrayList;

public class Q13_NextPermutation {
   public static ArrayList<Integer> arrayList= new ArrayList<>();

    static int getUpperBound(int number) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > number) {
                return i;
            }
        }
        return -1;
    }

    public static int nextPermutation(int[] arr){
        int i= arr.length-1;
        StringBuilder s= new StringBuilder();
        int index=-1;
        while(i-1>=0){
            arrayList.add(arr[i]);
            if(arr[i-1]<arr[i]){
                int upperBond=getUpperBound(arr[i-1]);
                arrayList.set(upperBond, arr[i - 1]);
                arr[i-1]=  arrayList.get(upperBond);
                index=i-1;
                break;
            }
            i--;
        }

        if(index==-1){
            arrayList.add(arr[0]);
        }
        for (int j = 0; j <=index; j++) {
            s.append(arr[j]);
        }
        for(Integer k:arrayList){
            s.append(k);
        }
        return Integer.parseInt(s.toString());
    }

    public static void main(String[] args) {
        int[] n= {1,2,3,4,5};
        System.out.println(nextPermutation(n));

    }
}
