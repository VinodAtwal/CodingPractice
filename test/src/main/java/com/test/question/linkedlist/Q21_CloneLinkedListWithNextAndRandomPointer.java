package com.test.question.linkedlist;

class NodeNR {
    public int data;
    public NodeNR next = null;
    public NodeNR random = null;

    public NodeNR(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NodeNR{" +
                "data=" + data +
                '}';
    }
}

public class Q21_CloneLinkedListWithNextAndRandomPointer {

    public static NodeNR cloneLLNR(NodeNR head) {
        NodeNR node = head;
        //adding clone as  next
        while (null != node) {
            NodeNR clone = new NodeNR(node.data);
            clone.next = node.next;
            node.next = clone;
            node = node.next.next;
        }
        node = head;
        //setting up random Pointer
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            } else {
                node.next.random = null;
            }
            node = node.next.next;
        }

        //Splitting clone ll
        NodeNR cloneHead = head.next;
        NodeNR cloneNode = head.next;
        node = head;

        while (null != node.next.next) {
            node.next = node.next.next;
            cloneNode.next = cloneNode.next.next;
            node = node.next;
            cloneNode = cloneNode.next;
        }
        
        //removing last node with original ll
        node.next = null;

        return cloneHead;

    }

    public static void main(String[] args) {
        NodeNR node1 = new NodeNR(1);
        NodeNR node2 = new NodeNR(2);
        NodeNR node3 = new NodeNR(3);
        NodeNR node4 = new NodeNR(4);
        NodeNR node5 = new NodeNR(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = node2;
        node3.random = node5;
        node5.random = node4;
        NodeNR node = node1;
        while (node != null) {
            System.out.println(node + " Random " + node.random);
            node = node.next;
        }
        System.out.println();
        NodeNR clone = cloneLLNR(node1);
        node = clone;
        while (node != null) {
            System.out.println(node + " Random " + node.random);
            node = node.next;
        }
        System.out.println();
        node = node1;
        while (node != null) {
            System.out.println(node + " Random " + node.random);
            node = node.next;
        }
    }


}
