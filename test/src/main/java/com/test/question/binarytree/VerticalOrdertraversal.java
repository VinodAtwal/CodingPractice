package com.test.question.binarytree;

import com.test.Utility.Pair;

import java.util.*;

public class VerticalOrdertraversal {

    public static void verticleOrderTraversal(Node root){
        Pair<Node ,Integer> pair = new Pair<>(root ,0);
        Queue<Pair<Node ,Integer>> queue = new LinkedList<>();
        queue.add(pair);
        Map<Integer, List<Node>> map = new TreeMap<>();

        while(!queue.isEmpty()){
            Integer size= queue.size();

            for(int i =1;i<=size;i++){
                Pair<Node ,Integer> p = queue.poll();
                map.putIfAbsent(p.getSecond(),new ArrayList<Node>());
                map.get(p.getSecond()).add(p.getFirst());
                if(p.getFirst().getLeft()!=null){
                    queue.add(new Pair<>(p.getFirst().left,p.getSecond()-1));
                }
                if(p.getFirst().getRight()!=null){
                    queue.add(new Pair<>(p.getFirst().right,p.getSecond()+1));
                }
            }

        }
        map.forEach((n1,n2)->{n2.forEach((n3)-> System.out.print(n3.data+" "));
            System.out.println();});


    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Node n1 = new Node(3);
        Node n2 = new Node(6);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(7);
        Node n6 = new Node(1);

        Node n7 = new Node(10);
        Node n8 = new Node(56);
        Node n9 = new Node(14);
        Node n10 = new Node(18);
        Node n11 = new Node(16);
        Node n12 = new Node(21);


        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        n3.left = n6;

        n4.left = n7;
        n7.right = n8;
        n8.right = n9;

        n2.left = n10;
        n10.left = n11;
        n11.right = n12;
        verticleOrderTraversal(root);


    }

    }


