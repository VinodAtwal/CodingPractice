package com.test.question.binarytree;

public class Q16_BinaryTreeDLL {

    public static Node binaryTreeDll(Node node , String s){
        Node leftNode=null;
        Node rightNode=null;
        if(node.left!=null){
            leftNode= binaryTreeDll(node.left,"left");
        }
        if(node.right!=null){
            rightNode= binaryTreeDll(node.right,"right");
        }

        if(leftNode!=null){
            node.left=leftNode;
            leftNode.right=node;
        }

        if(rightNode!=null){
            node.right=rightNode;
            rightNode.left=node;

        }

        if(s.equals("right")){
            while (node.left!=null){
                node=node.left;
            }
        }else{
            while (node.right!=null){
                node=node.right;
            }
        }
        return node;
    }

    public static Node prev=null;
    public static Node head=null;

    public static void binaryTreeDllOptimize(Node node){
        if (node==null){
            return;
        }
        binaryTreeDllOptimize(node.left);
        if(prev==null){
            head=node;
        }else{
            prev.right=node;
            node.left=prev;
        }
        prev=node;

        binaryTreeDllOptimize(node.right);
    }


    public static void main(String[] args) {
        Node root1 = new Node(10, new Node(20, new Node(40), new Node(60)), new Node(30));
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

      /*
                      5
                   /    \
                  6      7
                 / \    / \
                8   9   17   10
               / \
             11   N
        * */
//        Node ans =binaryTreeDll(root,"right");

        binaryTreeDllOptimize(root);

        while (head!=null){
            System.out.print(head.data+" ");
            head=head.right;
        }

//        while (ans!=null){
//            System.out.print(ans.data+" ");
//            ans=ans.right;
//        }
        /*p 7
        * c 10
        * 11->8->6->9->5
        * */

    }
}
