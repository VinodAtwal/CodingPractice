package com.test.question.trie;

import java.util.Arrays;
import java.util.LinkedList;

public class Q3_PrintAnagrams {
    static class TrieNodeLocal {
        public LinkedList<String> anagramList;
        public TrieNodeLocal[] children;
        public boolean isEndOfWord;

        public TrieNodeLocal() {
            this.anagramList = new LinkedList<>();
            this.children = new TrieNodeLocal[26];
            this.isEndOfWord=false;
        }

        @Override
        public String toString() {
            return "TrieNodeLocal{" +
                    "anagramList=" + anagramList +
                    ", children=" + Arrays.toString(children) +
                    ", isEndOfWord=" + isEndOfWord +
                    '}';
        }
    }

    public static void insertTrieTree(TrieNodeLocal root, String sortedData,String originalData){
        TrieNodeLocal node=root;
        for (int i = 0; i < sortedData.length(); i++) {
            char c = sortedData.charAt(i);
            int index =TrieInsertFindOperation.getIndex(c);
            if(node!=null){
                if(node.children[index]==null){
                    node.children[index]= new TrieNodeLocal();
                }
                node=node.children[index];


            }
        }
        node.isEndOfWord=true;
        node.anagramList.add(originalData);

    }

    public static void AddAndPrintAnagramToTrie(String[] array){
        TrieNodeLocal root = new TrieNodeLocal();
        for (int i = 0; i <array.length ; i++) {
            char[] word= array[i].toCharArray();
            Arrays.sort(word);
            insertTrieTree(root,String.valueOf(word),array[i]);
        }
        printAnagram(root);

    }

    public static void printAnagram(TrieNodeLocal root){
        if(root.isEndOfWord){
            System.out.println(root.anagramList);
        }
        for (int i = 0; i < 26; i++) {
            TrieNodeLocal node = root.children[i];
            if(node!=null){
               printAnagram(node);
            }
        }
    }

    public static void main(String[] args) {
        String wordArr[] = {"cat", "dog", "tac", "god",
                "act", "gdo" , "goddy","dgody"};
        AddAndPrintAnagramToTrie(wordArr);
    }
}
