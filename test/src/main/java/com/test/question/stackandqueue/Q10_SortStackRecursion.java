package com.test.question.stackandqueue;

import java.util.Stack;

public class Q10_SortStackRecursion {
    public static void insertAtRightPosition(Stack<Integer> stack, Integer data){
        if(stack.isEmpty() || stack.peek()>=data){
            stack.push(data);
            return;
        }
        Integer val= stack.pop();
        insertAtRightPosition(stack,data);
        stack.push(val);
    }

    public static void sortStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int val = stack.pop();
        sortStack(stack);
        insertAtRightPosition(stack,val);
    }

    public static void main(String[] args) {
        Stack<Integer>stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);

    }

}
