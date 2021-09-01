package com.test.question.backtracking;

import com.test.Utility.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class SolveTheSudoku {
    public static HashMap<Integer, HashSet<Integer>> colHash = new HashMap<>(9);
    public static HashMap<Integer, HashSet<Integer>> rowHash = new HashMap<>(9);
    public static HashMap<Integer, HashSet<Integer>> groupHash = new HashMap<>(9);

    public static int getGroup(int i, int j) {
        if (i < 3) {
            if (j < 3) {
                return 0;
            } else if (j < 6) {
                return 1;
            } else {
                return 2;
            }
        } else if (i < 6) {
            if (j < 3) {
                return 3;
            } else if (j < 6) {
                return 4;
            } else {
                return 5;
            }
        } else {
            if (j < 3) {
                return 6;
            } else if (j < 6) {
                return 7;
            } else {
                return 8;
            }
        }
    }


    public static void initialize(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] != 0) {
                    //row
                    rowHash.putIfAbsent(i, new HashSet<>());
                    HashSet<Integer> set = rowHash.get(i);
                    set.add(sudoku[i][j]);
                    rowHash.put(i, set);

                    //col
                    colHash.putIfAbsent(j, new HashSet<>());
                    set = colHash.get(j);
                    set.add(sudoku[i][j]);
                    colHash.put(j, set);

                    //group
                    int group = getGroup(i, j);
                    groupHash.putIfAbsent(group, new HashSet<>());
                    set = groupHash.get(group);
                    set.add(sudoku[i][j]);
                    groupHash.put(group, set);
                }
            }

        }
    }

    public static boolean validatePossibleValue(int i, int j, int k) {
        return !colHash.get(j).contains(k) && !rowHash.get(i).contains(k) && !groupHash.get(getGroup(i, j)).contains(k);
    }

    public static void addValue(int i, int j, int k, int[][] sudoku) {
        sudoku[i][j] = k;
        groupHash.get(getGroup(i, j)).add(k);
        rowHash.get(i).add(k);
        colHash.get(j).add(k);

    }

    public static void removeValue(int i, int j, int k, int[][] sudoku) {
        sudoku[i][j] = 0;
        groupHash.get(getGroup(i, j)).remove(k);
        rowHash.get(i).remove(k);
        colHash.get(j).remove(k);

    }

    public static int count = 0;

    public static boolean solveSudoku(int[][] sudoku, int row, int col) {
        for (int i = row; i < 9; i++) {
            int j = i == row ? col : 0;
            for (; j < 9; j++) {

                if (sudoku[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (validatePossibleValue(i, j, k)) {
                            addValue(i, j, k, sudoku);
                            if (solveSudoku(sudoku, i, j)) {
                                return true;
                            } else {
                                removeValue(i, j, k, sudoku);
                            }
                        }
                    }
                    return false;
                } else if (i == 8 && j == 8) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void printSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    static Pair<Integer, Integer> getInitGroupCoordinate(int groupNumber) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (getGroup(i, j) == groupNumber) {
                    return new Pair<>(i, j);
                }
            }
        }
        return new Pair<>(0, 0);
    }

    public static void solveOptimizationOnePossibility(int[][] sudoku, int row, int col) {

        count++;
        int x1, y1, x2, y2;
        Pair<Integer, Integer> pair = getInitGroupCoordinate(getGroup(row, col));
        x1 = pair.getFirst();
        y1 = pair.getSecond();
        x2 = x1 + 2;
        y2 = y1 + 2;


        La:
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                int value = 0;
                if (sudoku[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (validatePossibleValue(i, j, k)) {
                            if (value != 0) {
                                value = 0;
                                break;
                            }
                            value = k;
                        }
                    }
                    if (value != 0) {
                        addValue(i, j, value, sudoku);
                        solveOptimizationOnePossibility(sudoku, i, j);
                        break La;
                    }
                }
            }
        }
        // rows
        for (int i = 0; i < 9; i++) {
            int value = 0;
            if (sudoku[i][col] == 0) {
                for (int k = 1; k <= 9; k++) {
                    if (validatePossibleValue(i, col, k)) {
                        if (value != 0) {
                            value = 0;
                            break;
                        }
                        value = k;
                    }
                }
                if (value != 0) {
                    addValue(i, col, value, sudoku);
                    solveOptimizationOnePossibility(sudoku, i, col);
                    break;
                }
            }
        }

        // col
        for (int j = 0; j < 9; j++) {
            if (sudoku[row][j] == 0) {
                int value = 0;
                for (int k = 1; k <= 9; k++) {
                    if (validatePossibleValue(row, j, k)) {
                        if (value != 0) {
                            value = 0;
                            break;
                        }
                        value = k;
                    }
                }
                if (value != 0) {
                    addValue(row, j, value, sudoku);
                    solveOptimizationOnePossibility(sudoku, row, col);
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] sudoku =
                {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        initialize(sudoku);
//        solveOptimization(grid, 0, 0);

//        int count = 0;
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                count = grid[i][j] == 0 ? count + 1 : count;
//            }
//        }
//        System.out.println(count);
////        solveOptimization(grid, 0, 0);
//        solveSudoku(grid, 0, 0);
//        count = 0;
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                count = grid[i][j] == 0 ? count + 1 : count;
//            }
//
//        }
//        System.out.println(count);
        solveSudoku(sudoku, 0, 0);
        printSudoku(sudoku);
        System.out.println(count);


    }
}
