package com.test.question.backtracking;

public class RatInAMaze {

    public static void ratInMaze(int[][] maze, int x, int y, String ans, boolean[][] currentPath) {


        if (x < 0 || y < 0 || x > currentPath.length - 1 || y > currentPath.length - 1 || maze[x][y] == 0 || currentPath[x][y]) {
            return;
        }

        if (x == currentPath.length - 1 && y == currentPath.length - 1) {
            System.out.println(ans);
            return;
        }
        currentPath[x][y] = true;
        //right
        ratInMaze(maze, x + 1, y, ans + "R", currentPath);
        //left
        ratInMaze(maze, x - 1, y, ans + "L", currentPath);
        // top
        ratInMaze(maze, x, y - 1, ans + "T", currentPath);
        // down
        ratInMaze(maze, x, y + 1, ans + "D", currentPath);
        currentPath[x][y] = false;


    }

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        ratInMaze(maze, 0, 0, "", new boolean[maze.length][maze.length]);

    }
}
