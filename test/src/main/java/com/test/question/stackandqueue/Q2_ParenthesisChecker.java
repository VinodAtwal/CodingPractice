package com.test.question.stackandqueue;

import java.util.Stack;

public class Q2_ParenthesisChecker {
    public static Boolean balanceParanthesis(String s){
        Stack<Character> stack= new Stack<>();
        for(char a: s.toCharArray()){
            if(a=='(' || a=='{' || a=='['){
                stack.push(a);
            }else{
                switch (a){
                    case ']':
                        if(stack.pop()!='[') return false;
                        break;
                    case '}':
                        if(stack.pop()!='{') return false;
                        break;
                    case ')':
                        if(stack.pop()!='(') return false;
                        break;
                    default:
                        return false;
                }
            }

        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String s="{({}{{{((()))}()(())[()]}}[])}";
                //"{([])}";


        if(balanceParanthesis(s)){
            System.out.println("Balanced");
        }
        else{

            System.out.println("unbalaced");}


    }
}
