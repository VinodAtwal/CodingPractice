package com.test.dataStructure.graph;

import java.util.List;

public class DetectCycle {

    public static boolean detectCycleDirectedDFS(List<List<Integer>> adj, int s, boolean[] visited, boolean[] recStack) {
        visited[s] = true;
        recStack[s] = true;
        for (Integer i : adj.get(s)) {
            if (!visited[i] && detectCycleDirectedDFS(adj, i, visited, recStack)) {
                return true;
            } else if (recStack[i]) {
                return true;
            }
        }
        recStack[s] = false;
        return false;
    }

    public static boolean dfsDirected(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycleDirectedDFS(adj, i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUnDirectedDFS(List<List<Integer>> adj, int s, boolean[] visited, int parent) {
        visited[s] = true;
        for (Integer i : adj.get(s)) {
            if (!visited[i] && detectCycleUnDirectedDFS(adj, i, visited, s)) {
                return true;
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean dfsUnDirected(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycleUnDirectedDFS(adj, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

}
