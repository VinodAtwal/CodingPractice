package com.test.question.bitmanipulation;

public class Q2_BitDifference {

    public static int bitDif(int a, int b) {
        int c = a ^ b;
        int count = 0;
        /*
            5-> 0101
             4-> 0100
             3-> 0011
        */
        while (c > 0) {
            c = c & (c - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println(bitDif(a, b));
    }
}
