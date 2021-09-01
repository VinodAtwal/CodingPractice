package com.test.question.graph;

import com.test.Utility.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Q7_FindNumberIslands {
    public static boolean isSafe(char[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] != '0';
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    queue.add(new Pair<>(i, j));
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> pair = queue.poll();
                        if (isSafe(grid, pair.getFirst() + 1, pair.getSecond())) {
                            grid[pair.getFirst() + 1][pair.getSecond()] = '0';
                            queue.add(new Pair<>(pair.getFirst() + 1, pair.getSecond()));
                        }
                        if (isSafe(grid, pair.getFirst() - 1, pair.getSecond())) {
                            grid[pair.getFirst() - 1][pair.getSecond()] = '0';
                            queue.add(new Pair<>(pair.getFirst() - 1, pair.getSecond()));
                        }
                        if (isSafe(grid, pair.getFirst(), pair.getSecond() + 1)) {
                            grid[pair.getFirst()][pair.getSecond() + 1] = '0';
                            queue.add(new Pair<>(pair.getFirst(), pair.getSecond() + 1));
                        }
                        if (isSafe(grid, pair.getFirst(), pair.getSecond() - 1)) {
                            grid[pair.getFirst()][pair.getSecond() - 1] = '0';
                            queue.add(new Pair<>(pair.getFirst(), pair.getSecond() - 1));
                        }
                        if (isSafe(grid, pair.getFirst() + 1, pair.getSecond() + 1)) {
                            grid[pair.getFirst() + 1][pair.getSecond() + 1] = '0';
                            queue.add(new Pair<>(pair.getFirst() + 1, pair.getSecond() + 1));
                        }
                        if (isSafe(grid, pair.getFirst() - 1, pair.getSecond() - 1)) {
                            grid[pair.getFirst() - 1][pair.getSecond() - 1] = '0';
                            queue.add(new Pair<>(pair.getFirst() - 1, pair.getSecond() - 1));
                        }
                        if (isSafe(grid, pair.getFirst() + 1, pair.getSecond() - 1)) {
                            grid[pair.getFirst() + 1][pair.getSecond() - 1] = '0';
                            queue.add(new Pair<>(pair.getFirst() + 1, pair.getSecond() - 1));
                        }
                        if (isSafe(grid, pair.getFirst() - 1, pair.getSecond() + 1)) {
                            grid[pair.getFirst() - 1][pair.getSecond() + 1] = '0';
                            queue.add(new Pair<>(pair.getFirst() - 1, pair.getSecond() + 1));
                        }

                    }
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] arr =
                {{'0', '1', '1', '1', '0', '0', '0'}, {'0', '0', '1', '1', '0', '1', '0'}};

//                {{'0', '1'},
//                {'1', '0'},
//                {'1', '1'},
//                {'1', '0'}};

        System.out.println(numIslands(arr));
    }
}
