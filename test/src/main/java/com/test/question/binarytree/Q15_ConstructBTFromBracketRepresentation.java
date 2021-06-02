package com.test.question.binarytree;

public class Q15_ConstructBTFromBracketRepresentation {
    public static int index=0;

    public static Node constructBinaryTree(String given){
        char c= given.charAt(index);
        Node node=null;
        if(Character.isDigit(c)){
           node = new Node(Integer.valueOf(c+""));
        }
        index++;


        if(index<given.length() && given.charAt(index)=='('){
            index++;
            node.left=constructBinaryTree(given);
        }

        if(index<given.length() && given.charAt(index)=='('){
            index++;
            node.right=constructBinaryTree(given);
        }

        if (index<given.length() && given.charAt(index)==')'){
            index++;
        }
        return node;

    }

    public static void main(String[] args) {
        String s=
//        "4(2(3(7)(8))(1))(6(5))";
                "1(2)(3)";
        Node node = constructBinaryTree(s);
        System.out.println(node);
        Q6_Preorder.preorderRecursion(node);


    }


}
