package com.test.question.binarytree;

public class Q20_SumNodesLongestPathFromRootToLeafNode {

    public static int heightMax=0;
    public static int maxPathSum=0;

    public static  void sumNodeLongestPathFromRootTOLeafNode(Node root ,int height,int sum){
        if(root==null){
            if(heightMax<height){
                heightMax=height;
                maxPathSum=sum;
            }
            return;
        }
        sumNodeLongestPathFromRootTOLeafNode(root.left,height+1,sum+root.data);
        sumNodeLongestPathFromRootTOLeafNode(root.right,height+1,sum+root.data);

    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Node n1 = new Node(6);
        Node n2 = new Node(7);
        Node n3 = new Node(8);
        Node n4 = new Node(9);
        Node n5 = new Node(10);
        Node n6 = new Node(11);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        n3.left = n6;
        sumNodeLongestPathFromRootTOLeafNode(root,0,0);
        System.out.println("PathSum "+maxPathSum +" height "+heightMax);


    }

}
