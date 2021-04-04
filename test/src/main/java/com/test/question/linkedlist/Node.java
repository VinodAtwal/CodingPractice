package com.test.question.linkedlist;

public class Node {
    public Integer data;
    public Node next;
    public Node(Integer data){
        this.data=data;

    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
