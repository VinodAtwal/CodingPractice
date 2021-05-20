package com.test.question.stackandqueue;

import java.util.Stack;

public class Q12_LongestValidSubString {

    public static int longestValidSubString(String s){
        int maxValidLength=0;
        int leftCounter=0;
        int rightCounter=0;

        /*iterate from left -> right then only left bracket can be
        greater than right if right is greater then reset counter
        vice-versa for right to left*/

        //left->right
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                ++leftCounter;
            }else{
                ++rightCounter;
            }
            if(leftCounter==rightCounter){
                maxValidLength=Math.max(maxValidLength,leftCounter);
            }else if(rightCounter>leftCounter){
                leftCounter=0;
                rightCounter=0;
            }
        }
        //right->left
        rightCounter=leftCounter=0;

        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i)=='('){
                ++leftCounter;
            }else{
                ++rightCounter;
            }
            if(leftCounter==rightCounter){
                maxValidLength=Math.max(maxValidLength,leftCounter);
            }else if(rightCounter<leftCounter){
                leftCounter=0;
                rightCounter=0;
            }
        }
        return maxValidLength;
    }

    public static int longestValidSubStringStack(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxValidSuBString =0;

        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else {
                if(!stack.isEmpty()){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    maxValidSuBString= Math.max(maxValidSuBString,i-stack.peek());
                }
                if(stack.isEmpty()){
                    stack.push(i);
                }
            }
        }
        return maxValidSuBString;

    }

    public static void main(String[] args) {
        String s="(()()((((())))()((())()";
        System.out.println(longestValidSubString(s)*2);
        System.out.println(longestValidSubStringStack(s));
    }
}
