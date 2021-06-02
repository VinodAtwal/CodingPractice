package com.test.question.trie;

import java.util.LinkedList;

public class Q4_PhoneDirectory {

    public static boolean printAnagram(Q3_PrintAnagrams.TrieNodeLocal root){
        boolean flag =false;
        if(root.isEndOfWord){
            System.out.print(root.anagramList +" ");
            flag = true;
        }

        for (int i = 0; i < 26; i++) {
            Q3_PrintAnagrams.TrieNodeLocal node = root.children[i];
            if(node!=null){
               flag= printAnagram(node) || flag;
            }
        }
        return flag;
    }

    public static void phoneDirectory(String[] arr , String input){
        Q3_PrintAnagrams.TrieNodeLocal node = new  Q3_PrintAnagrams.TrieNodeLocal();
        for (int i = 0; i < arr.length ; i++) {
            Q3_PrintAnagrams.insertTrieTree(node,arr[i],arr[i]);
        }

        for (int i = 0; i < input.length(); i++) {
            int index = TrieInsertFindOperation.getIndex(input.charAt(i));
            node = node != null ? node.children[index] : node;
//            node =node.children[index];

            if(node!=null && printAnagram(node) ){
                System.out.println();
            }else{
                System.out.println(0);
            }


        }
    }

    public static void main(String[] args) {
        String[] arr= {"geeikistest", "geeksforgeeks",
                "geeksfortest"};
        String s="geeips";
        phoneDirectory(arr,s);
    }

}
