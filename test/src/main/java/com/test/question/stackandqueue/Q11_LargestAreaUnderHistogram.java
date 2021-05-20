package com.test.question.stackandqueue;

import java.util.Stack;

public class Q11_LargestAreaUnderHistogram {

    public static  int maxAreaUnderHistogram(int[] arr){
        int area=0;
        int index=0;
        Stack<Integer> stack= new Stack<>();

        while(index<arr.length || !stack.isEmpty()){
            // If this bar is higher than the bar on top stack, push it to stack
            if(index<arr.length && (stack.isEmpty() || arr[stack.peek()]<=arr[index])){
                stack.push(index);
                index++;
            }else{

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
                //if index is reached to length then pop element and repeat same operation
                //currArea=arr[i] * (stack.empty() ? index : index - stack.peek() - 1);
                int i = stack.pop();
                int currArea=0;

                if(stack.isEmpty()){
                    currArea= arr[i] * index;
                }else {
                    currArea = arr[i] * (index - stack.peek() - 1);
                }
                area= Math.max(area,currArea);
            }

        }
        return area;
    }

    public static void main(String[] args) {
        int[] arr ={ 6, 2, 5, 5, 4, 6 };
        System.out.println(maxAreaUnderHistogram(arr));
    }
}
