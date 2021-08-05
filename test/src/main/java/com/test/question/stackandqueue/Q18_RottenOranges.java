package com.test.question.stackandqueue;

import com.test.Utility.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Q18_RottenOranges {

    public static int rottenOrangeQueueSolution(int[][] array) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 2) {
                    queue.add(new Pair<>(i, j));
                }
            }
        }

        int step = 0;

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
                if (j - 1 >= 0 && array[i][j - 1] == 1) {
                    array[i][j - 1] = 2;
                    queue.add(new Pair<>(i, j - 1));
                }
                // right
                if (j + 1 < array[0].length && array[i][j + 1] == 1) {
                    array[i][j + 1] = 2;
                    queue.add(new Pair<>(i, j + 1));
                }
                //top
                if (i - 1 >= 0 && array[i - 1][j] == 1) {
                    array[i - 1][j] = 2;
                    queue.add(new Pair<>(i - 1, j));
                }
                //down
                if (i + 1 < array.length && array[i + 1][j] == 1) {
                    array[i + 1][j] = 2;
                    queue.add(new Pair<>(i + 1, j));
                }

            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 1) {
                    return -1;
                }
            }
        }
        return step;

    }

    public static void main(String[] args) {
        int[][] array = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        int[][] array1 = {{0, 1, 1, 2}, {0, 1, 1, 2}, {1, 2, 1, 1}};
        int[][] array2 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 2}};

        System.out.println(rottenOrangeQueueSolution(array));
        System.out.println(rottenOrangeQueueSolution(array1));
        System.out.println(rottenOrangeQueueSolution(array2));
    }
}
