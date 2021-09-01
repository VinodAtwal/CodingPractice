package com.test.question.backtracking;

import java.util.Arrays;

public class TheKnightTourProblem {
    public static int maxStepRemain = 0;

    /*leftTop, leftbottom
     * topleft, topright
     * right top , right bottom
     * bottomLeft bootom right*/

//    public static int xIndex[] = {2, 1, -1, -2, -2, -1, 1, 2};
//    public static int yIndex[] = {1, 2, 2, 1, -1, -2, -2, -1};

   /* Orignal
   public static int[] xIndex = {2,  2, -1, 1, -2, -2, -1, 1};
    public static int[] yIndex = {1, -1, -2, -2, -1, 1, 2, 2};*/

    public static int[] xIndex = {2, 1, 2, 1, -2, -1, -1, -2};
    public static int[] yIndex = {1, 2, -1, -2, 1, 2, -2, -1};


    public static boolean theKnightTourProblem(int[][] chess, int i, int j) {

        boolean flag = false;
        for (int k = 0; k < xIndex.length && !flag; k++) {
            int x = i + xIndex[k];
            int y = j + yIndex[k];
            if (x >= 0 && y >= 0 && x < 6 && y < 6 && chess[x][y] < 0) {
                maxStepRemain++;
                if (maxStepRemain > 35) {
                    for (int l = 0; l < 6; l++) {
                        System.out.println(Arrays.toString(chess[l]));
                    }
                    return true;
                }
                chess[x][y] = maxStepRemain;
                flag = theKnightTourProblem(chess, x, y);
                if (!flag) {
                    maxStepRemain--;
                    chess[x][y] = -1;
                }
            }

        }

        return flag;


    }

    public static void main(String[] args) {
        int[][] chess = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                chess[i][j] = -1;
            }

        }
        chess[0][0] = 0;
        theKnightTourProblem(chess, 0, 0);
        Arrays.toString(chess);


    }
}
