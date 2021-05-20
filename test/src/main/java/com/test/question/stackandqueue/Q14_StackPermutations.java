package com.test.question.stackandqueue;

import java.util.Stack;

public class Q14_StackPermutations {
    public static boolean stackPermutationOrNot(int[] input ,int[] output){
        int inputIndex=0,outputIndex=0;
        Stack<Integer> stack = new Stack<>();

        while((inputIndex<input.length && outputIndex<output.length ) || !stack.isEmpty()){
            if (!stack.isEmpty() && stack.peek() == output[outputIndex]) {
                stack.pop();
                outputIndex++;
            } else if (inputIndex < input.length && input[inputIndex] == output[outputIndex]) {
                inputIndex++;
                outputIndex++;
            } else if (inputIndex == input.length) {
                    return false;
            }else{
                stack.push(input[inputIndex]);
                inputIndex++;
            }
        }

        return outputIndex==output.length;
    }

    public static void main(String[] args) {
        int[] input={1, 2, 3 };
        int[] output={3, 2,1 ,4};
        System.out.println("Given i/p is stack Permutaion "+stackPermutationOrNot(input,output));
    }
}
