package com.test.question.binarytree;

import com.test.Utility.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q21_DuplicateSubtreeBinaryTree {

    public static HashMap<Integer, Set<Integer>> hashMap =  new HashMap<>();

    public static HashSet<String> hashSet = new HashSet<>();


    public static boolean containsDuplicateBinaryTree(Node root){
        boolean bool=false;
        hashMap.putIfAbsent(root.data,new HashSet<>());
        Set <Integer> children = hashMap.get(root.data);

        if(root.left!=null){
           bool=bool || children.contains(root.left.data);

        }
        if(root.right!=null ){
            bool=bool|| children.contains(root.right.data);

        }
        if(root.left!=null && !bool){
            children.add(root.left.data);
            hashMap.put(root.data, children);
            bool=bool || containsDuplicateBinaryTree(root.left);
        }
        if(!bool && root.right!=null ){
            children.add(root.right.data);
            hashMap.put(root.data, children);
            bool=bool||containsDuplicateBinaryTree(root.right);
        }
        return bool;
    }

    //if it contains the String it retuns "" empty string else serialize string
    public static String containsDuplicateBinaryTreeStandard(Node node){
        if(node==null){
            return "#";
        }
        String s="";
        String separator=",";

        String lst= containsDuplicateBinaryTreeStandard(node.left);
        if(s.equals(lst)){
            return s;
        }
        String rst= containsDuplicateBinaryTreeStandard(node.right);
        if(s.equals(rst)){
            return s;
        }
        String ans = node.data+separator+lst+separator+rst;

        if((node.left!=null || node.right!=null)  && hashSet.contains(ans)){
            return s;
        }
        hashSet.add(ans);
        return ans;
    }


    public static void main(String[] args) {
        Node root = new Node(5);
        Node n1 = new Node(6);
        Node n2 = new Node(8);
        Node n3 = new Node(8);
        Node n4 = new Node(9);
        Node n5 = new Node(11);
        Node n6 = new Node(11);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        n3.left = n6;

//        System.out.println(containsDuplicateBinaryTree(root));
        System.out.println(containsDuplicateBinaryTreeStandard(root).equals(""));


      /*
                      5
                   /    \
                  6      8
                 / \    / \
                8   9   17   10
               / \
             11   18
        * */
    }




}
