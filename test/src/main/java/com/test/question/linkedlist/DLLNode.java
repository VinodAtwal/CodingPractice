package com.test.question.linkedlist;

public class DLLNode {
    Integer data;

    DLLNode prev = null;
    DLLNode next = null;

    public DLLNode(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DLLNode{" +
                "data=" + data +
                '}';
    }
}
