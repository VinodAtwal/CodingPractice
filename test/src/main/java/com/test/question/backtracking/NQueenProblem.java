package com.test.question.backtracking;

import com.test.Utility.Pair;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

    public static void printSolution(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(" " + board[i][j]
                        + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] chess, int x, int y) {
        for (int i = y; i >= 0; i--) {
            if (chess[x][i] == 1) {
                return false;
            }
        }
        int i = x, j = y;
        while (i < chess.length && i >= 0 && j < chess[0].length && j >= 0) {
            if (chess[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }
        i = x;
        j = y;
        while (i < chess.length && i >= 0 && j < chess[0].length && j >= 0) {
            if (chess[i][j] == 1) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static boolean NQueen(int[][] chess, int col) {
        if (col >= chess[0].length) {
            printSolution(chess);
            return true;
        }
        for (int i = 0; i < chess.length; i++) {
            if (isSafe(chess, i, col)) {
                chess[i][col] = 1;
                if (NQueen(chess, col + 1)) {
                    return true;
                }
                chess[i][col] = 0;
            }
        }
        return false;
    }

    public static List<Pair<Integer, Integer>> list = new ArrayList<>();
    public static int count = 0;

    public static void NQueenStandard(int size, int row) {
        for (int i = 0; i < size; i++) {
            if (isSafeStandard(row, i)) {
                list.add(new Pair<Integer, Integer>(row, i));
                if (row != size - 1) {
                    NQueenStandard(size, row + 1);
                } else {
                    count++;
                }

                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isSafeStandard(int row, int i) {
        for (Pair<Integer, Integer> pair : list) {
            int l = pair.getFirst();
            int k = pair.getSecond();
            if (((l == row) || (k == i) || (l + k == row + i) || (l - k == row - i))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int board[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
//        System.out.println(NQueen(board, 0));
        NQueenStandard(9, 0);
        System.out.println(count);
    }
}
