package com.test.question.trie;

public class TrieInsertFindOperation {

    static int getIndex(char ch) {
        return ch >= 'A' && ch <= 'Z' ? ch - 'A' : ch - 'a';
    }


    public static void insertTrieTree(TrieNode root,String dataGiven){
        TrieNode node=root;
        for (int i = 0; i < dataGiven.length(); i++) {
            char c = dataGiven.charAt(i);
            int index =getIndex(c);
            if(node!=null){
                if(node.children[index]==null){
                    node.children[index]=new TrieNode();
                }
                node=node.children[index];

            }
        }
        node.isEndOfWord=true;
    }

    public static boolean findInTrieTree(TrieNode root,String dataGiven){
        if(root==null){
            return false;
        }
        TrieNode node=root;
        for (int i = 0; i < dataGiven.length(); i++) {
            char c = dataGiven.charAt(i);
            int index =getIndex(c);
                if(node.children[index]==null){
                   return false;
                }
                node=node.children[index];
            }

        return node.isEndOfWord;
    }

    public static void main(String[] args) {

       TrieNode root= new TrieNode();
       insertTrieTree(root,"KUKKY");
       insertTrieTree(root,"KUKKYVA");
        insertTrieTree(root,"VINODATWAL");
       System.out.println(findInTrieTree(root,"KUKKYVA"));

    }


}
