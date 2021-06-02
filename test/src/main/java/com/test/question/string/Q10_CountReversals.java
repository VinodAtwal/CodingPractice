package com.test.question.string;

public class Q10_CountReversals {

    public  static int countReversalSingleLoop(String given){
        int leftUnbalance=0;
        int rightUnbalance=0;
        int count=0;
        if(given.length()%2!=0){
            return -1;
        }
        for (int i = 0; i < given.length(); i++) {
            if(given.charAt(i)=='{'){
                leftUnbalance++;
            }else{
                if(leftUnbalance==0){
                    rightUnbalance++;
                }else{
                    leftUnbalance--;
                }
            }
        }
        if(leftUnbalance>1){
            count+=1+(leftUnbalance-1)/2;
        }else{
            count+=leftUnbalance;
        }
        if(rightUnbalance>1){
            count+=1+(rightUnbalance-1)/2;
        }else{
            count+=rightUnbalance;
        }
        return count;

    }


    public static int countReversal(String given){
        if(given.length()%2!=0){
            return -1;
        }
        int count=0;
        int leftCounter=0;
        int rightCounter=0;
        int leftUnbalance=0;
        int rightUnbalance=0;

        for (int i = 0; i < given.length(); i++) {
            char c= given.charAt(i);
            if(c=='{'){
                ++leftCounter;
            }else{
                ++rightCounter;
            }
            if(rightCounter>leftCounter) {
                rightUnbalance++;
                leftCounter=rightCounter=0;
            }
        }
        leftCounter=rightCounter=0;
        for (int i = given.length()-1; i >=0 ; i--) {
            char c= given.charAt(i);
            if(c=='{'){
                ++leftCounter;
            }else{
                ++rightCounter;
            }
            if(rightCounter<leftCounter) {
                leftUnbalance++;
                leftCounter=rightCounter=0;
            }
        }
        //counting reversal
        //if odd  (odd-1)/2 +1 reversal for even even/2 reversal
        count =  leftUnbalance + rightUnbalance - (int)(leftUnbalance/2) - (int)(rightUnbalance/2);
        return count;
    }

    public static void main(String[] args) {
        String s=
//                "{{{}}{{{}}";
//                "{{{{";
//                "{{}{{{}{{}}{{";
                "}{{}}{{{";
        System.out.println(countReversal(s));
        System.out.println(countReversalSingleLoop(s));
    }
}
