package com.test.question.matrix;

public class Q1_PrintSpiralArray {

    public static void printSpiralArray(Integer[][]arr ){
        Integer row = arr.length-1;
        Integer col = arr[0].length-1;
        Integer rowmin=0;
        Integer colmin=0;

        while( rowmin<=row || colmin<=col) {
            if(rowmin<=row) {
                for (Integer j = colmin; j <= col; j++) {
                    System.out.print(arr[rowmin][j] + " ");
                }
            }
            rowmin++;

            if(colmin<=col) {
                for (Integer i = rowmin; i <= row; i++) {
                    System.out.print(arr[i][col] + " ");
                }
            }
            col--;
            if(rowmin<=row) {
                for (Integer j = col; j >= colmin; j--) {
                    System.out.print(arr[row][j] + " ");
                }
            }
            row--;
            if(colmin<=col)  {
                for (Integer i = row; i >= rowmin; i--) {
                    System.out.print(arr[i][colmin] + " ");
                }
            }
            colmin++;

        }
    }


    public static void main(String[] args) {
       Integer[][]  arr =
               {
                       {1,  2, 3},
                       {4,  5, 6},
                       {7,  8, 9},
                       {11,12,13},
                       {14,15,16},
                       {17,18,19},
                       {20,21,22},
               };

//               { { 1, 2, 3, 4, 5, 6 },
//               { 7, 8, 9, 10, 11, 12 },
//               { 13, 14, 15, 16, 17, 18 } };
//                        {{1, 2, 3, 4},
//                       {5, 6, 7, 8},
//                       {9, 10, 11, 12},
//                       {13, 14, 15,16}};

        printSpiralArray(arr);

    }
}
