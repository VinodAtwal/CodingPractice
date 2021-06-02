package com.test.question.string;

public class Q5_PermutationsOfString {

    public static void permutationOfString(String ans,String given){
        if(given.length()==0){
            System.out.print(ans+" ");
            return;
        }

        for (int i = 0; i < given.length(); i++) {
            permutationOfString(ans+given.charAt(i),given.substring(0,i)+given.substring(i+1));
        }

    }

    public static void main(String[] args) {
        String s="ABC";
        permutationOfString("",s);
    }
}
