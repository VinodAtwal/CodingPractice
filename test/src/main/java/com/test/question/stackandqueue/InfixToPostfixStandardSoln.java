package com.test.question.stackandqueue;

import java.util.HashSet;
import java.util.Stack;

public class InfixToPostfixStandardSoln {

    public static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 10;
            case '*':
            case '/':
                return 20;
            case '^':
                return 30;
        }
        return -1;
    }

    public static HashSet<Character> openBracket = new HashSet<>();
    public static HashSet<Character> closeBracket = new HashSet<>();

    static {
        openBracket.add('(');
        openBracket.add('{');
        openBracket.add('[');
        closeBracket.add(']');
        closeBracket.add('}');
        closeBracket.add(')');
    }

    public static String infixToPostFix(String expression){
        String result="";
        Stack<Character> operator= new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c= expression.charAt(i);

            if(Character.isLetterOrDigit(c)){
                result+=c;
            }else if(openBracket.contains(c)){
                operator.push(c);
            }else if(closeBracket.contains(c)){
                while (!operator.isEmpty() && !openBracket.contains(operator.peek())){
                    result+=operator.pop();
                }
                operator.pop();
            }else{
                while (!operator.isEmpty() && !openBracket.contains(c) && precedence(operator.peek()) >=precedence(c) ){
                    result+=operator.pop();
                }
                operator.push(c);
            }
        }
        while (!operator.isEmpty()){
            result+=operator.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String s ="(A-B)*[C/(D+E)+F]";
        System.out.println(infixToPostFix(s));
    }
}
