package com.test.question.heap;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q1_BuildingHeapFromArray {
    /*Root is at index 0 in array.
Left child of i-th node is at (2*i + 1)th index.
Right child of i-th node is at (2*i + 2)th index.
Parent of i-th node is at (i-1)/2 index.*/
    public static void buildingHeapFromArray(List<Integer> array) {
        for (int i = (array.size() / 2) - 1; i >= 0; i--) { // ((arrayLength-1) -1)/2
            Heap.heapifyMax(array, i);
            // Heap.heapifyMin(array,i);
        }
    }

    public static void main(String[] args) {
        List<Integer> array = IntStream.of(1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17).boxed().collect(Collectors.toList());
        buildingHeapFromArray(array);
        System.out.println(array);
    }
}
