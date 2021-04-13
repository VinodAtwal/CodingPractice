package com.test.question.stackandqueue;

public class Q1_TwostackArray {
    Integer arr[] = new Integer[4];
    Integer s1index =-1;
    Integer s2index=arr.length;


    Boolean isfull(){
       return s1index+1==s2index ? true : false;
    }

    public void push1(Integer data){
        if(isfull()){
            System.out.println("Stack is full ");
            return;
        }
        ++s1index;
        arr[s1index]=data;

    }
    public void push2(Integer data){
        if(isfull()){
            System.out.println("Stack is full ");
            return;
        }
        --s2index;
        arr[s2index]=data;

    }

    public Integer pop1(){
        if(s1index==-1) {
            System.out.println("stack is empty");
            return -1;
        }
        Integer i = s1index;
        --s1index;
        return arr[i];

    }

    public Integer pop2(){
        if(s2index==arr.length) {
            System.out.println("stack is empty");
            return -1;
        }
        Integer i = s2index;
        ++s2index;
        return arr[i];
    }
    public void display(){
        for(Integer i: arr){
            System.out.print(i+" ");
        }
    }


    public static void main(String[] args) {
        Q1_TwostackArray twostack = new Q1_TwostackArray();
        twostack.push1(1);
        twostack.push1(2);

//        twostack.push1(3);
//        twostack.push1(4);
//        twostack.push1(5);

        twostack.push2(7);
//        twostack.push2(8);
//        twostack.push2(9);
        twostack.push2(10);
        twostack.push1(12);
        twostack.pop2();
        twostack.pop2();
        twostack.pop2();

    }
}
