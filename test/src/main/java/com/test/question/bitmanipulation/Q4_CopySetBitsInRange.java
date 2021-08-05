package com.test.question.bitmanipulation;

public class Q4_CopySetBitsInRange {
    public static int copySetBitsInRange(int x, int y, int l, int r) {

        /**
         * Remove the out of range bits from y and keep only bits within given range
         */
        y = y >>> (l - 1);
        y = y << (l - 1);

        y = y << (32 - r);
        y = y >>> (32 - r);

        x = x | y;
        return x;

    }

    public static void main(String[] args) {
//        System.out.println(copySetBitsInRange(23697, 23063, 1, 1));

        System.out.println(3 + 100 / 10 * 2 - 13);

    }
}
