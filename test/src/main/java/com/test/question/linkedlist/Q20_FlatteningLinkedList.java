package com.test.question.linkedlist;

class NodeBN {
    public NodeBN next = null;
    public NodeBN bottom = null;
    public int data;

    public NodeBN(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NodeBN{" +
                "data=" + data +
                '}';
    }
}

public class Q20_FlatteningLinkedList {

    public static void settleNode(NodeBN head, NodeBN toSettle) {
        while (head.next != null && head.next.data < toSettle.data) {
            head = head.next;
        }
        toSettle.next = head.next;
        head.next = toSettle;
    }

    public static void flatteningLL(NodeBN head) {

        while (head.bottom != null || head.next != null) {
            if (head.bottom != null) {
                NodeBN node = head.bottom;
                head.bottom = null;
                settleNode(head, node);
            }
            head = head.next;
        }
    }

    public static void flattenBottom(NodeBN head) {
        while (head != null) {
            head.bottom = head.next;
            head.next = null;
            head = head.bottom;
        }
    }

    public static void main(String[] args) {
        NodeBN node1 = new NodeBN(5);
        NodeBN node2 = new NodeBN(7);
        NodeBN node3 = new NodeBN(8);
        NodeBN node4 = new NodeBN(30);
        NodeBN node5 = new NodeBN(10);
        NodeBN node6 = new NodeBN(20);
        NodeBN node7 = new NodeBN(19);
        NodeBN node8 = new NodeBN(22);
        NodeBN node9 = new NodeBN(50);
        NodeBN node10 = new NodeBN(28);
        NodeBN node11 = new NodeBN(35);
        NodeBN node12 = new NodeBN(40);
        NodeBN node13 = new NodeBN(45);

        node1.bottom = node2;
        node2.bottom = node3;
        node3.bottom = node4;
        node1.next = node5;
        node5.bottom = node6;
        node5.next = node7;
        node7.bottom = node8;
        node8.bottom = node9;
        node7.next = node10;
        node10.bottom = node11;
        node11.bottom = node12;
        node12.bottom = node13;

//        node1.bottom = node2;
//        node2.bottom = node3;
//        node3.bottom = node4;
//        node1.next = node5;
//        node5.bottom = node6;
//        node5.next = node7;
//        node7.bottom = node8;
//        node8.bottom = node9;
//        node7.next = node10;
//        node10.bottom = node11;
//        node11.bottom = node12;
//        node12.bottom = node13;

        flatteningLL(node1);
        flattenBottom(node1);
        while (node1 != null) {
            System.out.println(node1);
            node1 = node1.bottom;
        }


//        while (node1 != null) {
//            System.out.println(node1);
//            node1 = node1.next;
//        }

     /*   while (node1 != null) {
            System.out.println();
            NodeBN node = node1;
            while (node != null) {
                System.out.print(node);
                node = node.bottom;
            }
            node1 = node1.next;
        }*/

    }
}
