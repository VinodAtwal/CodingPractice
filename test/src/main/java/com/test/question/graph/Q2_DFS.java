package com.test.question.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class Q2_DFS {

    public static void dfs(ArrayList<ArrayList<Integer>> arrayList){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited= new boolean[arrayList.size()];

        for (int i = 0; i <arrayList.size() ; i++) {
            if (!visited[i]) {
                stack.add(i);
                while (!stack.isEmpty()) {
                    Integer vertex = stack.pop();
                    if (!visited[vertex]) {
                        visited[vertex]=true;
                        System.out.print(vertex + " ");
                        stack.addAll(arrayList.get(vertex));
                    }
                }
            }
        }



    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayList= new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(2);arr.add(3);
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(4);
        arrayList.add(0,arr);
        arrayList.add(1,new ArrayList<Integer>());
        arrayList.add(2,arr1);
        arrayList.add(3,new ArrayList<Integer>());
        arrayList.add(4,new ArrayList<Integer>());
        dfs(arrayList);








    }
}
