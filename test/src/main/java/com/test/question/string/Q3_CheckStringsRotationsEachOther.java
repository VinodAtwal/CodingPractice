package com.test.question.string;

public class Q3_CheckStringsRotationsEachOther {

    public static boolean checkStringsRotationOfEachOther(String main,String test){
        String s= main+main;
        return s.contains(test);
    }

    public static void main(String[] args) {
        System.out.println(checkStringsRotationOfEachOther("ABCD","CDAB"));
    }
}
