package com.test.dynamicprograming;

import com.test.Utility.Utility;

public class o1KnapSack {

    public static int maxValKnapSack01Recursive(int[] wt, int[] val, int capacityWt, int index) {
        if (index == 0 || capacityWt == 0) {
            return 0;
        }
        if (capacityWt >= wt[index - 1]) {
            return Math.max(val[index - 1] + maxValKnapSack01Recursive(wt, val, capacityWt - wt[index - 1], index - 1),
                    maxValKnapSack01Recursive(wt, val, capacityWt, index - 1));
        }
        return maxValKnapSack01Recursive(wt, val, capacityWt, index - 1);
    }


    public static int maxValKnapSack01RecursiveMemomize(int[] wt, int[] val, int capacityWt, int index, int[][] recuSoln) {
        if (recuSoln[index][capacityWt] != -1) {
            return recuSoln[index][capacityWt];
        }
        if (index == -1 || capacityWt == 0) {
            recuSoln[index][capacityWt] = 0;
            return 0;

        }
        if (capacityWt >= wt[index - 1]) {
            recuSoln[index][capacityWt] = Math.max(val[index - 1] + maxValKnapSack01Recursive(wt, val, capacityWt - wt[index - 1], index - 1),
                    maxValKnapSack01Recursive(wt, val, capacityWt, index - 1));
            return recuSoln[index][capacityWt];
        }
        recuSoln[index][capacityWt] = maxValKnapSack01Recursive(wt, val, capacityWt, index - 1);
        return recuSoln[index][capacityWt];
    }


    public static void main(String[] args) {

        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int w = 7;
        int[][] recuSoln = new int[wt.length + 1][w + 1];
        Utility.initialize2DArrayWithNegOne(recuSoln);

//        System.out.println(Arrays.toString(recuSoln));
//        System.out.println(maxValKnapSack01Recursive(wt, val, w, wt.length - 1));
        System.out.println(maxValKnapSack01RecursiveMemomize(wt, val, w, wt.length, recuSoln));

    }
}