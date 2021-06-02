package com.test.question.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {


    public static int getLeftChild(int root){
        return 2*root+1;
    }
    public static int getRightChild(int root){
        return 2*root+2;
    }

    public static  int getParentIndex(int child){
        return (child-1)/2;
    }

    public static int deleteMinHeap(List<Integer> heap,int index){
        if(!(index<heap.size())) {
            return -1;
        }
        int lastElement =heap.remove(heap.size()-1);
        int poppedElement = heap.get(index);

        if(heap.size()>0){
            heap.set(index,lastElement);
            heapifyMin(heap,index);

        }
        return poppedElement;
    }

    public static int deleteMaxHeap(List<Integer> heap,int index){
        if(!(index<heap.size())) {
            return -1;
        }
        int lastElement =heap.remove(heap.size()-1);
        int poppedElement = heap.get(index);

        if(heap.size()>0){
            heap.set(index,lastElement);
            heapifyMax(heap,index);
        }
        return poppedElement;
    }

    public static int reverseMinHeapify(List<Integer> heap,int index ){
        int data = heap.get(index);
        int parentIndex = getParentIndex(index);
        while (parentIndex >= 0 && heap.get(parentIndex)> data){
            heap.set(index,heap.get(parentIndex));
            heap.set(parentIndex,data);
            index=parentIndex;
            parentIndex = getParentIndex(index);
        }
        return data;
    }

    public static int modifyMinHeap(List<Integer> heap,int index , int data){
        if(index >heap.size() || index<0){
            System.out.println("Out of Range");
            return -1;
        }

        if(heap.get(index)< data){
            heap.set(index,data);
            heapifyMin(heap,index);
        }else{

            heap.set(index,data);
            reverseMinHeapify(heap,index);
        }
        return data;

    }

    public static int reverseMaxHeapify(List<Integer> heap, int index){
        int parentIndex = getParentIndex(index);
        int data = heap.get(index);
        while (parentIndex >= 0 && heap.get(parentIndex)<data){
            heap.set(index,heap.get(parentIndex));
            heap.set(parentIndex,data);
            index=parentIndex;
            parentIndex = getParentIndex(index);
        }
        return data;
    }

    public static int modifyMaxHeap(List<Integer> heap,int index , int data){
        if(index >heap.size() || index<0){
            System.out.println("Out of Range");
            return -1;
        }
        if(heap.get(index)> data){
            heap.set(index,data);
            heapifyMax(heap,index);

        }else{
            heap.set(index,data);
            reverseMaxHeapify(heap,index);
        }
        return data;

    }

    public static int insertMinHeap(List<Integer> heap, int data){
        heap.add(data);
        int currentIndex = heap.size()-1;
        int parentIndex= getParentIndex(currentIndex);
        while (parentIndex >=0 && heap.get(parentIndex)>data ){
           heap.set(currentIndex,heap.get(parentIndex));
           heap.set(parentIndex,data);
           currentIndex=parentIndex;
           parentIndex=getParentIndex(currentIndex);
        }
        return currentIndex;

    }

    public static int insertMaxHeap(List<Integer> heap, int data){
        heap.add(data);
        int currentIndex = heap.size()-1;
        int parentIndex= getParentIndex(currentIndex);

        while (parentIndex >=0&& heap.get(parentIndex)<data ){
            heap.set(currentIndex,heap.get(parentIndex));
            heap.set(parentIndex,data);
            currentIndex=parentIndex;
            parentIndex=getParentIndex(currentIndex);
        }
        return currentIndex;

    }

    public static int popMinHeap(List<Integer> heap){
        int popedElement =heap.remove(heap.size()-1);
        if (heap.size() > 0) {
            heap.set(0,popedElement);
            heapifyMin(heap,0);
        }
        return popedElement;
    }
    public static int popMaxHeap(List<Integer> heap){
        int popedElement =heap.remove(heap.size()-1);
        if (heap.size() > 0) {
            heap.set(0,popedElement);
            heapifyMax(heap,0);
        }
        return popedElement;
    }

    public static void heapifyMin(List<Integer> heap ,int index){
        int min = index;
        int left = 2*index+1;
        int right = 2*index+2;

        if(left<heap.size() && heap.get(min)>heap.get(left)){
            min=left;
        }
        if(right<heap.size() && heap.get(min)>heap.get(right)){
            min=right;
        }
        if(min!=index){
            int val = heap.get(index);
            heap.set(index,heap.get(min));
            heap.set(min,val);
            heapifyMin(heap,min);
        }
    }

    public static void heapifyMax(List<Integer> heap ,int index){
        int max = index;
        int left = 2*index+1;
        int right = 2*index+2;

        if(left<heap.size() && heap.get(max)<heap.get(left)){
            max=left;
        }
        if(right<heap.size() && heap.get(max)<heap.get(right)){
            max=right;
        }
        if(max!=index){
            int val = heap.get(index);
            heap.set(index,heap.get(max));
            heap.set(max,val);
            heapifyMax(heap,max);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList= new ArrayList<>();
        insertMinHeap(arrayList,2);

        insertMinHeap(arrayList,5);

        insertMinHeap(arrayList,3);

        insertMinHeap(arrayList,0);

        insertMinHeap(arrayList,1);

        insertMinHeap(arrayList,7);


//        insertMaxHeap(arrayList,4);
//
//        insertMaxHeap(arrayList,5);
//
//        insertMaxHeap(arrayList,3);
//
//        insertMaxHeap(arrayList,1);
//
//        insertMaxHeap(arrayList,7);

        System.out.println(arrayList);
//            modifyMinHeap(arrayList,2,8);
//        deleteMinHeap(arrayList,2);
//        heapifyMin(arrayList,2);
        
//        deleteMaxHeap(arrayList,1);
//        modifyMaxHeap(arrayList,1,0);
        System.out.println(arrayList);
       




    }


}
