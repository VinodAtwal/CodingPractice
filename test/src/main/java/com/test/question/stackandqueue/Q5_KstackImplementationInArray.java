package com.test.question.stackandqueue;

public class Q5_KstackImplementationInArray {

    static class KStack{
        int[] arr;
        int[] next;
        int[] top;
        int free;
        int n;
        int k;

        public KStack(int n, int k) {
            this.n = n;
            this.k = k;
            this.arr= new int[n];
            this.next=new int[n];
            this.top= new int[k];
            this.free=0;

            for (int i = 0; i < k; i++) {
                top[i]=-1;
            }

            for (int i = 0; i < n-1; i++) {
                next[i]=i+1;
            }
            next[n-1]=-1;
        }

        public boolean isEmpty(int kthStack){
           return top[kthStack]==-1;
        }

        public boolean isFull(int kthStack){
            return free==-1;
        }

        public void push( int data , int kthStack){
            if(!isFull(kthStack)){
                int i = free;
                free= next[i];
                arr[i]=data;
                next[i]= top[kthStack];
                top[kthStack]=i;
            }else{
                System.out.println(kthStack+ "th Stack is Full can't add Elements");
            }
        }

        public int pop(int kthStack){
            if(!isEmpty(kthStack)){
//                int value= arr[top[kthStack]];
//                int i = free;
//
//                free=top[kthStack];
//                next[top[kthStack]]= i;
//                top[kthStack]=next[top[kthStack]];
//                return value;

                int i = top[kthStack];
                top[kthStack]=next[i];
                next[i]=free;
                free=i;

                return arr[i];

            }else{
                System.out.println(kthStack+ "th Stack is Empty can't pop Elements");
            }
            return Integer.MIN_VALUE;
        }

    }

    public static void main(String[] args) {
        KStack kStack= new KStack(10,3);
        kStack.push(10,0);
        kStack.push(11,1);
        kStack.push(12,1);
        kStack.push(13,1);
        kStack.push(14,0);
        kStack.push(15,0);
        kStack.push(16,2);
        kStack.push(17,2);
        kStack.push(18,2);
        System.out.println(kStack.pop(0));
        System.out.println(kStack.pop(1));
        System.out.println(kStack.pop(1));
        System.out.println(kStack.pop(1));
        System.out.println(kStack.pop(0));
        System.out.println(kStack.pop(0));
        System.out.println(kStack.pop(2));
        System.out.println(kStack.pop(2));
        System.out.println(kStack.pop(2));
        System.out.println(kStack.pop(1));


    }
}
