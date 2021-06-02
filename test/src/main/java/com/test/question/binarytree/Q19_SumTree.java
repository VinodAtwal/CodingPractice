package com.test.question.binarytree;

public class Q19_SumTree {
    public static Integer sumTree(Node root){
        if(root.left==null && root.right==null){
            return root.data;
        }

        Integer leftData=0,rightData=0;

        if(root.left!=null) {
             leftData = sumTree(root.left);
        }
        if(root.right!=null) {
            rightData = sumTree(root.right);
        }

        if(leftData==null || rightData==null){
            return null;
        }

        return  root.data==leftData+rightData ? root.data +leftData+rightData:null;
    }

    public static void main(String[] args) {
        Node correct = new Node(3, new Node(1), new Node(2));
        System.out.println(sumTree(correct)!=null);

    }

}
