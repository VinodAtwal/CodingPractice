package com.test.question.string;

public class Q11_CountAllPalindromicSubsequence {

    public static int countAllPalindromicSubsequence(String op,String ip,int index){
        if(index==ip.length()){
            if( !op.equals("") && op.equals(new StringBuilder(op).reverse().toString()) ){
                return 1;
            }else{
                return 0;
            }
        }
        return countAllPalindromicSubsequence(op+ip.charAt(index),ip,index+1)
                + countAllPalindromicSubsequence(op,ip,index+1) ;
    }

    public static void main(String[] args) {
        String s="aaaa";
        System.out.println(countAllPalindromicSubsequence("",s,0));

    }
}
