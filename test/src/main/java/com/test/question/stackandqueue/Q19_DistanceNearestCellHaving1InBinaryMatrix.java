package com.test.question.stackandqueue;

import com.test.Utility.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Q19_DistanceNearestCellHaving1InBinaryMatrix {
    public static int distanceNearestCellHaving1InBinaryMatrix(int[][] array) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 1) {
                    queue.add(new Pair<>(i, j));
                }
            }
        }

        int step = 1;

        queue.add(new Pair<>(-1, -1));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> element = queue.poll();
            int i = element.getFirst();
            int j = element.getSecond();

            if (i == -1 && j == -1) {
                if (!queue.isEmpty()) {
                    step++;
                    queue.add(element);
                }
            } else {


                // left
                if (j - 1 >= 0 && array[i][j - 1] == 0) {
                    array[i][j - 1] = step + 1;
                    queue.add(new Pair<>(i, j - 1));
                }
                // right
                if (j + 1 < array[0].length && array[i][j + 1] == 0) {
                    array[i][j + 1] = step + 1;
                    queue.add(new Pair<>(i, j + 1));
                }
                //top
                if (i - 1 >= 0 && array[i - 1][j] == 0) {
                    array[i - 1][j] = step + 1;
                    queue.add(new Pair<>(i - 1, j));
                }
                //down
                if (i + 1 < array.length && array[i + 1][j] == 0) {
                    array[i + 1][j] = step + 1;
                    queue.add(new Pair<>(i + 1, j));
                }

            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] - 1 + " ");
            }
            System.out.println();
        }
        return step;
    }

    public static void main(String[] args) {
        int[][] array = {
                {0, 0, 1, 1, 0},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 0, 1}
        };
        distanceNearestCellHaving1InBinaryMatrix(array);
    }
}
