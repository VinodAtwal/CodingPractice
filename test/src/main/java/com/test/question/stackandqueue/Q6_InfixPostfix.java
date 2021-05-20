package com.test.question.stackandqueue;

import java.util.HashMap;
import java.util.Stack;

public class Q6_InfixPostfix {
    public  static HashMap<Character,Integer> precedence= new HashMap<>();
    static {
        precedence.put('{',40);
        precedence.put('[',40);
        precedence.put('(',40);
        precedence.put('^',3);
        precedence.put('/',2);
        precedence.put('*',2);
        precedence.put('+',1);
        precedence.put('-',1);

    }
    static boolean isOpenBracket(char bracket) {
        Integer order = precedence.get(bracket);
        return order != null && order == 40;
    }


    public static String convertInfixToPostfix(String input){
        Stack<String> operand= new Stack<>();
        Stack<Character> operator= new Stack<>();


        String output="";

        for (int i = 0; i < input.length(); i++) {
            char c= input.charAt(i);
            switch (c){
                case '+':
                case '/':
                case '*':
                case '^':
                case '-':
                {
                  if(!operator.isEmpty()){
                      if(precedence.get(operator.peek())==40){
                          operator.push(c);
                      }else if(precedence.get(operator.peek())>=precedence.get(c)){
                          while(!operator.isEmpty() && precedence.get(operator.peek())!=40 &&precedence.get(operator.peek())>=precedence.get(c) ){
                              String s2= operand.pop();
                              String s1= operand.pop();
                              operand.add(s1+s2+operator.pop());
                          }

                          operator.push(c);
                      }else{
                          operator.push(c);
                      }
                  }else{
                      operator.add(c);
                  }
                  break;

                }
                case '{':
                case '[':
                case '(':
                {
                    operator.push(input.charAt(i));
                    break;
                }
                case '}':
                case ']':
                case ')':
                {
                    while(precedence.get(operator.peek())!=40){
                        String s2= operand.pop();
                        String s1= operand.pop();
                        operand.add(s1+s2+operator.pop());
                    }
                    operator.pop();
                    break;
                }

                default:{
                    operand.add(c+"");
                }
            }

        }
        while (!operator.isEmpty()){
            String s2= operand.pop();
            String s1= operand.pop();
            operand.push(s1+s2+operator.pop());
        }
        output=operand.pop();

        return output;

    }

    public static void main(String[] args) {
        String s="a+b*(c^d-e)^(f+g*h)-i";
                //"a+b*A^B-i";
                    //a bAB^*
                    //+-
//                "a+b*(c^d-e)^(f+g*h)-i";
//                "A+B/C^D";
                //"(A-B)*[G^C/(D+E)+F]";
                //"(A-B)*[C/(D+E)+F]";

        System.out.println(convertInfixToPostfix(s));
    }
}
