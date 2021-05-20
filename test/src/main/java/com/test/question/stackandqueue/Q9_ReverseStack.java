package com.test.question.stackandqueue;

import java.util.Stack;

public class Q9_ReverseStack {
    public static void reverseStack(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }

        int val = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, val);

    }
    public static void insertAtBottom(Stack<Integer> stack , Integer data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int val = stack.pop();
        insertAtBottom(stack,data);
        stack.push(val);

    }
    public static void main(String[] args) {
        Stack<Integer>stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        reverseStack(stack);
        System.out.println(stack);

    }
}
