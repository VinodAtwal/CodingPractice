package com.test.question.string;

public class Q4_PrintAllSubsequencesString {

    public static void printAllSubSequenceOsString(String ans,String given){

        if(given.length()==0){
            System.out.print(ans+" ");
            return;
        }
        printAllSubSequenceOsString(ans+given.substring(0,1),given.substring(1));
        printAllSubSequenceOsString(ans,given.substring(1));
    }

    public static void main(String[] args) {
        String s="abc";
//        printAllSubSequenceOsString("",s);

    }
}
