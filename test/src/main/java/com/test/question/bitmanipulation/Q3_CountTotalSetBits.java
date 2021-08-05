package com.test.question.bitmanipulation;

public class Q3_CountTotalSetBits {

    public static int countTotalSetBit(int num) {
        int i = 0;
        int count = 0;
        while (Math.pow(2, i) <= num) {
            //+1 for adding 0 , becz pattern consider from 0  not  1
            int bitRange = (int) Math.pow(2, i);
            count += bitRange * ((num + 1) / (2 * bitRange));

            int rem = (num + 1) % (2 * bitRange);
            rem = rem - bitRange;
            count += rem > 0 ? rem : 0;
            i++;

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countTotalSetBit(5));
    }
}
