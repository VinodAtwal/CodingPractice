package com.test.question.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1_BFSofGraph {
    public static void BFSofGraph(ArrayList<ArrayList<Integer>> arrayList){
        Queue<Integer> queue= new LinkedList<>();
        boolean[] visited = new boolean[arrayList.size()];

        queue.add(0);
        while(!queue.isEmpty()){
            Integer element=queue.poll();
            if(!visited[element]) {
                System.out.print(element + " ");
                queue.addAll(arrayList.get(element));
                visited[element]=true;
            }

        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayList= new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(2);arr.add(3);
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(4);
        arr1.add(1);
        arrayList.add(0,arr);
        arrayList.add(1,new ArrayList<Integer>());
        arrayList.add(2,arr1);
        arrayList.add(3,new ArrayList<Integer>());
        arrayList.add(4,new ArrayList<Integer>());
        BFSofGraph(arrayList);

    }
}
