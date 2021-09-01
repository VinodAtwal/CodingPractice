package com.test.question.backtracking;

import java.util.Arrays;

public class FindShortestSafeRoutePathWithLandmines {

    public static void processLandMineBastArea(int[][] land) {
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    land[i][j] = 3;
                    if (i - 1 >= 0 && land[i - 1][j] != 0) {
                        land[i - 1][j] = 3;
                    }
                    if (j - 1 >= 0 && land[i][j - 1] != 0) {
                        land[i][j - 1] = 3;
                    }
                    if (i + 1 < land.length && land[i + 1][j] != 0) {
                        land[i + 1][j] = 3;
                    }
                    if (j + 1 < land[0].length && land[i][j + 1] != 0) {
                        land[i][j + 1] = 3;
                    }
                }
            }

        }
    }

    public static int shortestLength = Integer.MAX_VALUE;

    public static void findShortestSafeRoutePathWithLandmines(int[][] land) {
        processLandMineBastArea(land);

        for (int i = 0; i < land.length; i++) {
            findShortestSafeRoutePathWithLandminesRecursive(land, i, 0, 0);
        }
    }

    public static void findShortestSafeRoutePathWithLandminesRecursive(int[][] land, int i, int j, int count) {
        if (j == land[0].length) {
            shortestLength = Math.min(shortestLength, count);
            return;
        } else if (i < 0 || j < 0 || i >= land.length || count >= shortestLength || land[i][j] == 3 || land[i][j] == 9) {
            return;
        }
        // 9 for visited
        land[i][j] = 9;
        findShortestSafeRoutePathWithLandminesRecursive(land, i - 1, j, count + 1);
        findShortestSafeRoutePathWithLandminesRecursive(land, i + 1, j, count + 1);
        findShortestSafeRoutePathWithLandminesRecursive(land, i, j - 1, count + 1);
        findShortestSafeRoutePathWithLandminesRecursive(land, i, j + 1, count + 1);
        land[i][j] = 1;
    }

    public static void main(String[] args) {
        int[][] land = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1}};
        findShortestSafeRoutePathWithLandmines(land);
//        processLandMineBastArea(land);
        for (int[] i : land) {
            System.out.println(Arrays.toString(i));
        }

        System.out.println(shortestLength);

    }

}
