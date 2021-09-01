package com.test.question.graph;

import java.util.Arrays;

public class Q9_DijkstraAlgo {
    public static int[] dijkstra(int[][] graph, int src) {
        int V = graph.length;
        boolean[] finalised = new boolean[V];
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        for (int i = 0; i < V - 1; i++) {

            int u = -1;
            // finding minimum distance from distance Array and putting it in finalized state
            for (int j = 0; j < V; j++) {
                if (!finalised[j] && (u == -1 || distance[j] < distance[u])) {
                    u = j;
                }
            }

            finalised[u] = true;
            // updating all adjacent of u to minimum state
            for (int j = 0; j < V; j++) {
                if (!finalised[j] && graph[u][j] != 0) {
                    distance[j] = Math.min(distance[j], distance[u] + graph[u][j]);
                }
            }


        }

        return distance;

    }

    public static void main(String[] args) {
        int[][] graph = {{0, 5, 10, 0},
                {5, 0, 3, 20},
                {10, 3, 0, 2},
                {0, 20, 2, 0}
        };
        
        System.out.println(Arrays.toString(dijkstra(graph, 0)));

    }
}
