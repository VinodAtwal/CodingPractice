package com.test.question.graph;

import com.test.Utility.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q4_FloodFill {

    public static void floodFillBFS(int[][] vil, int sx, int sy, int newColor) {
        Pair<Integer, Integer> pair = new Pair<>(sx, sy);
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(pair);
        if (vil[sx][sy] == 1) {
            vil[sx][sy] = newColor;
        }
        while (!queue.isEmpty()) {
            pair = queue.poll();
            int x = pair.getFirst();
            int y = pair.getSecond();
            //left
            if (isSafe(vil, x, y - 1) && vil[x][y - 1] != newColor) {
                vil[x][y - 1] = newColor;
                queue.add(new Pair<>(x, y - 1));
            }
            //right
            if (isSafe(vil, x, y + 1) && vil[x][y + 1] != newColor) {
                vil[x][y + 1] = newColor;
                queue.add(new Pair<>(x, y + 1));
            }
            //top
            if (isSafe(vil, x - 1, y) && vil[x - 1][y] != newColor) {
                vil[x - 1][y] = newColor;
                queue.add(new Pair<>(x - 1, y));
            }
            //bottom
            if (isSafe(vil, x + 1, y) && vil[x + 1][y] != newColor) {
                vil[x + 1][y] = newColor;
                queue.add(new Pair<>(x + 1, y));
            }
        }

    }

    public static boolean isSafe(int[][] vil, int x, int y) {
        return x >= 0 && y >= 0 && x < vil.length && y < vil[x].length && vil[x][y] != 0;
    }

    public static void main(String[] args) {
        int vil[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFillBFS(vil, 1, 1, 2);

        for (int[] a : vil) {
            System.out.println(Arrays.toString(a));
        }
    }
}
