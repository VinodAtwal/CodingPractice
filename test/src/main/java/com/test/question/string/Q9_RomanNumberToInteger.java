package com.test.question.string;

import java.util.HashMap;
import java.util.Map;

public class Q9_RomanNumberToInteger {
    public static Map<Character,Integer> hashmap = new HashMap<>();
    static {
        hashmap.put('I',1);
        hashmap.put('V',5);
        hashmap.put('X',10);
        hashmap.put('L',50);
        hashmap.put('C',100);
        hashmap.put('D',500);
        hashmap.put('M',1000);
    }

    public static int romanNumberToInt(String input){
        int sum=0;
        int precednce=0;
        for (int i = input.length()-1; i >=0 ; i--) {
            Character c= input.charAt(i);
            int val=hashmap.get(c);
            if(precednce<=val){
                precednce=val;
                sum+=val;
            }else{
                sum-=val;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s="IVX";
        System.out.println(romanNumberToInt(s));
    }
}
