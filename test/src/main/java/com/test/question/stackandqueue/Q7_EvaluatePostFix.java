package com.test.question.stackandqueue;

import java.util.Stack;

public class Q7_EvaluatePostFix {
    public  static int evaluatePostFix(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c= exp.charAt(i);
            if(Character.isDigit(c)){
                stack.push(c+"");
            }else{
                int i2= Integer.parseInt(stack.pop());
                int i1= Integer.parseInt(stack.pop());
                int result=0;
                switch (c){
                    case '+':
                        result=i1+i2;
                        break;
                    case '-':
                        result=i1-i2;
                        break;
                    case '*':
                        result=i1*i2;
                        break;
                    case '/':
                        result=i1/i2;
                        break;
                    case '^':
                        result=(int ) Math.pow(i1,i2);
                        break;
                }
                stack.push(result+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String postFixExp="1234^/+";
                //"231*+9-";
        System.out.println(evaluatePostFix(postFixExp));
    }

}
