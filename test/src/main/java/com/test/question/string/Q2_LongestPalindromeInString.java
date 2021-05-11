package com.test.question.string;

import java.util.Arrays;


class a{
    public int a=5;
    protected void t1(){

    }
}
class b extends a {
    public int a=6;
    @Override
    public void t1(){

    }
}

public class Q2_LongestPalindromeInString {
    public static String longestPalindromeGivenString(String s){
        String sHash= s.replaceAll("","#");
        String soln=null;
        Integer maxlength= Integer.MIN_VALUE;
        Integer maxindex=0;

        Integer[] arr = new Integer[sHash.length()];

        for(int i=0 ; i<sHash.length();i++){
            int j=i-1;
            int k=i+1;
            while(j>=0 && k<sHash.length() && sHash.charAt(j)==sHash.charAt(k)){
                j--;
                k++;
            }
            ++j;--k;

            arr[i]=k-i;

            maxindex =maxlength<arr[i]?i:maxindex;
            maxlength= Math.max(arr[i],maxlength);

        }

        soln=sHash.substring(maxindex-arr[maxindex], maxindex+arr[maxindex]+1);

        soln= soln.replaceAll("#","");

        return soln;

    }

    public static void palindromeGivenStringMancher(String s){
        String sHash= s.replaceAll("","#");
        Integer[] arr = new Integer[sHash.length()];
        String soln=null;
        Integer i=0;
        while (i<sHash.length()){
            int j=i,k=i;
            while(j-1>=0 && k+1<sHash.length() && sHash.charAt(j-1)==sHash.charAt(k+1)){
                j--;
                k++;
            }
            arr[i]=k-i;
            if(arr[i]>1){
                Integer count= arr[i],palLeft=i;
                while (--count >0){
                    arr[++i]= Math.min(arr[--palLeft],count);
                }
            }else {
                i++;
            }
        }



        for (int z = 0; z < arr.length; z++) {
            if(arr[z]>=3){
                String palin=sHash.substring(z-arr[z], z+arr[z]+1);
                System.out.println(palin.replaceAll("#",""));
            }
        }

        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void main(String[] args) {
       //palindromeGivenStringMancher("abaabc");



    }
}
