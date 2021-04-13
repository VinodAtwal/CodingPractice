package com.test.question.stackandqueue;

import java.util.Stack;

public class Q3_NextGreater{

    public  static void nextGreater(Integer[] arr){
        Stack<Integer> stack = new Stack<>();
        Integer[] ans = new Integer[arr.length];
        Integer index=arr.length-1;

        while(index>=0){
            if(stack.isEmpty()){
                ans[index] =-1;
                stack.push(arr[index]);
                index--;
                continue;
            }
            if(arr[index]<stack.peek()){
                    ans[index] =stack.peek();
                    stack.push(arr[index]);
                    index--;
            }else{
                stack.pop();
            }
        }
        for(Integer i:ans) System.out.print(i+" ");
    }
    public static void main(String[] args){
        Integer arr[] ={6,8,0,1,3};
                //{1 ,3 ,2 ,4};
        nextGreater(arr);
    }
}
