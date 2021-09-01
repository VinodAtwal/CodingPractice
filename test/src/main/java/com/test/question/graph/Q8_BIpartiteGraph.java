package com.test.question.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q8_BIpartiteGraph {
    public static boolean isBipartiteUtil(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] col = new int[V];
        Arrays.fill(col, -1);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (col[i] == -1) {
                queue.add(i);
                col[i] = 0;

                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    int curCol = col[cur];
                    for (int j : adj.get(cur)) {
                        if (col[j] == curCol) {
                            return false;
                        }

                        if (col[j] == -1) {
                            col[j] = curCol == 0 ? 1 : 0;
                            queue.add(j);
                        }
                    }
                }
            }
        }
        return true;
    }
}
