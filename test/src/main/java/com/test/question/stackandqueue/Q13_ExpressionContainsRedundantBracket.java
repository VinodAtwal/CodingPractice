package com.test.question.stackandqueue;

import java.util.Stack;

public class Q13_ExpressionContainsRedundantBracket {

    public static Boolean expressionCpntainingRdundentBraket(String s){
        Stack<Character> stack= new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c==')'){
                int count=0;
                while(stack.pop()!='('){
                    ++count;
                }
                if(count<=1){ // is 1 means only single value is there ,(-1) maeans 2 value this is not redundant
                    return true;
                }
                // x is random element replace bracket expresion
                stack.push('x');

            }else{
                stack.push(c);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String s="(a*(b+c))";
        System.out.println("Given String has Redundant Bracket "+expressionCpntainingRdundentBraket(s));

    }
}
