package com.test.question.bitmanipulation;

public class Q1_FindTwoNonRepeatingNo {
    public static void findTwoNonRepeatingNo(int[] arr) {
        int xor = 0;
        for (int i : arr) {
            xor = xor ^ i;
        }
        int firstBitSet = xor & ~(xor - 1);
        int a = 0, b = 0;

        for (int i : arr) {
            if ((firstBitSet & i) == 0) {
                a = a ^ i;
            } else {
                b = b ^ i;
            }
        }

        System.out.println(a + " " + b);
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 7, 9, 2, 4};
        findTwoNonRepeatingNo(arr);
    }
}
