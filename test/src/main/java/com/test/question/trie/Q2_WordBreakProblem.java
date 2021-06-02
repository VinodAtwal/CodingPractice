package com.test.question.trie;

import java.util.Arrays;

public class Q2_WordBreakProblem {

    public static boolean workBreak(TrieNode root,String givenString , int index){
        if(index==givenString.length()){
            return true;
        }
        boolean bool =false;
        TrieNode node =root;

        for (int i = index; i <givenString.length() && !bool; i++) {
            int pos = TrieInsertFindOperation.getIndex(givenString.charAt(i));
            node= node.children[pos];
            if(node!=null){
                if(node.isEndOfWord){
                   bool=bool||workBreak(root,givenString,i+1);
                }
            }else{
                return bool;
            }
        }
        return bool;
    }

    public static void main(String[] args) {
//        String[] str = { "mobile", "samsung",
//                "sam", "sung", "ma",
//                "mango", "icecream",
//                "and", "go", "i", "like",
//                "ice", "cream" };
//        String input="ilikesamsung";
//        String[] str = {"i", "like", "sa", "amsung", "sung", "mobile", "ice",
//                "cream", "icecream", "man", "go", "mango"};
//            String[] str = {"i", "like", "sam", "sa", "sung", "mobile", "ice",
//                    "cream", "icecream", "man", "go", "mango"};
//        String input = "ILikeSAMSUNGMobile";
        String[] str = {"i", "like", "sa", "amsung", "sung", "mobile", "ice",
                "cream", "icecream", "man", "go", "mango"};
        String input = "ilikeIcereaman";

        TrieNode root = new TrieNode();
        Arrays.stream(str).forEach((i)->TrieInsertFindOperation.insertTrieTree(root,i));

        System.out.println(workBreak(root,input,0));

    }
}
