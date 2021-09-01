package com.test.question.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q3_MinimumStepByKnight {

    static class UnitCell {
        public int x, y, dist;

        public UnitCell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static int minimumStepsByKnight(int[] initialPos, int[] targetPos) {
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        int[][] matrix = new int[9][9];
        matrix[initialPos[0]][initialPos[1]] = 1;
        Queue<UnitCell> queue = new LinkedList<>();
        queue.add(new UnitCell(initialPos[0], initialPos[1], 0));

        while (!queue.isEmpty()) {
            UnitCell cell = queue.poll();
            if (cell.x == targetPos[0] && cell.y == targetPos[1]) {
                return cell.dist;
            }

            for (int i = 0; i < 8; i++) {
                int x = cell.x + dx[i];
                int y = cell.y + dy[i];

                if (isSafe(x, y) && matrix[x][y] != 1) {
                    matrix[x][y] = 1;
                    queue.add(new UnitCell(x, y, cell.dist + 1));
                }

            }
        }

        return -1;

    }

    public static boolean isSafe(int i, int j) {
        return i >= 0 && j >= 0 && i < 8 && j < 8;
    }

    public static void main(String[] args) {
        int knightPos[] = {4, 5};
        int targetPos[] = {1, 1};
        System.out.println(minimumStepsByKnight(knightPos, targetPos));
    }
}
