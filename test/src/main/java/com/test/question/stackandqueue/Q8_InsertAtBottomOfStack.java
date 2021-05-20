package com.test.question.stackandqueue;

import java.util.Stack;

public class Q8_InsertAtBottomOfStack {


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
        insertAtBottom(stack,5);

        System.out.println(stack);

    }
}
