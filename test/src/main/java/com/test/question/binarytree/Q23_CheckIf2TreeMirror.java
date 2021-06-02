package com.test.question.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q23_CheckIf2TreeMirror {

    public static boolean checkIf2TreesMirrorOrNot(int[] tree1,int[] tree2) {

        //assuming both tree contains same no of nodes means both array have same size
        Map<Integer, Stack<Integer>> treeChildrenMap = new HashMap<>();

        for (int i = 0; i < tree1.length; i = i + 2) {
            int key = tree1[i];
            int child = tree1[i + 1];
            treeChildrenMap.putIfAbsent(key, new Stack<Integer>());
            treeChildrenMap.get(key).push(child);
        }

        for (int i = 0; i < tree2.length; i = i + 2) {
            int key = tree2[i];
            int child = tree2[i + 1];
            if (!(treeChildrenMap.containsKey(key) && treeChildrenMap.get(key).pop() == child)) {
                return false;
            }


        }
        return true;
    }

    public static void main(String[] args) {
        int A[] = {1,2,1,3, 2,4,2,5,3,6,3,7};
        int B[] = {1,3,1,2, 3,7,3,6,2,5,2,4};

        System.out.println(checkIf2TreesMirrorOrNot(A,B));
    }

}
