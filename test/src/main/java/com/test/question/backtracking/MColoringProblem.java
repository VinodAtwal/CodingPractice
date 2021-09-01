package com.test.question.backtracking;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {

    public static List<List<Integer>> convertEdgeListToAdjacencyList(int[][] edge, int V) {
        List<List<Integer>> adjacencyList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edge.length; i++) {
            adjacencyList.get(edge[i][0]).add(edge[i][1]);
            adjacencyList.get(edge[i][1]).add(edge[i][0]);
        }
        return adjacencyList;
    }

    //color index start from 1-> M
    public static boolean isValidColor(List<Integer> adjacent, int[] color, int colorIndex) {
        for (Integer i : adjacent) {
            if (color[i] == colorIndex) {
                return false;
            }
        }
        return true;
    }

    public static boolean mColoringProblemBfsRec(List<List<Integer>> adjacencyList, int curr, int[] color, int totalColors) {
        if (curr == adjacencyList.size()) {
            return true;
        }
        for (int i = 1; i <= totalColors; i++) {
            if (isValidColor(adjacencyList.get(curr), color, i)) {
                color[curr] = i;
                if (mColoringProblemBfsRec(adjacencyList, curr + 1, color, totalColors)) {
                    return true;
                } else {
                    color[curr] = 0;
                }
            }
        }
        return false;

    }


    public static void main(String[] args) {
//        System.out.println(mColoringProblem(abc, V, M));
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 2}};
        int V = 4;
        int M = 3;
      /*  int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        int V = 3;
        int M = 2;
*/

        List<List<Integer>> abc = convertEdgeListToAdjacencyList(edges, V);
        int[] color = new int[V];

        System.out.println(mColoringProblemBfsRec(abc, 0, color, M));


    }

}
