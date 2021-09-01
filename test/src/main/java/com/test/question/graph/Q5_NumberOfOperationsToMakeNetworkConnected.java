package com.test.question.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q5_NumberOfOperationsToMakeNetworkConnected {
    public static int dfs(List<List<Integer>> arrayList) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            if (!visited[i]) {
                count++;
                stack.add(i);
                while (!stack.isEmpty()) {
                    Integer vertex = stack.pop();
                    if (!visited[vertex]) {
                        visited[vertex] = true;
                        stack.addAll(arrayList.get(vertex));
                    }
                }
            }
        }
        return count;
    }

    public static int makeConnected(int n, int[][] connections) {
        List<List<Integer>> adjacencyList = new ArrayList<>(n);
        int edge = 0;
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] ar : connections) {
            edge++;
            adjacencyList.get(ar[0]).add(ar[1]);
            adjacencyList.get(ar[1]).add(ar[0]);
        }
        int comp = dfs(adjacencyList);
        System.out.println(edge);

        System.out.println(comp);
        if (edge < n - 1) {
            return -1;
        }
        int redundant = edge - ((n - 1) - (comp - 1));
        if (redundant >= (comp - 1)) {
            return comp - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(makeConnected(4, arr));
    }
}
