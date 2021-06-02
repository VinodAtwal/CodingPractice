package com.test.question.trie;

public class Q1_FindShortestUniquePrefixForEveryWord {

    static int getIndex(char ch) {
        return ch >= 'A' && ch <= 'Z' ? ch - 'A' : ch - 'a';
    }

    public static String findShortestUniquePrefixForGivenWord(TrieNode root, String givenWord) {
        TrieNode node = root;
        String op="";
        for (int i = 0; i < givenWord.length(); i++) {
            char c = givenWord.charAt(i);
            int index = getIndex(c);
            node = node.children[index];
            op+=c;
            if (node.freq < 2) {
                break;
            }
        }
        return op;
    }

    public static void insertTrieTree(TrieNode root, String dataGiven) {
        TrieNode node = root;
        for (int i = 0; i < dataGiven.length(); i++) {
            char c = dataGiven.charAt(i);
            int index = getIndex(c);
            if (node != null) {
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.freq++;
            }
        }
        node.isEndOfWord = true;
    }

    public static void findShortestUniquePrefixForEveryWord(String[] arr) {
        TrieNode root = new TrieNode();

        for (int i = 0; i < arr.length; i++) {
            insertTrieTree(root, arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(findShortestUniquePrefixForGivenWord(root, arr[i]) + " ");
        }

    }


    public static void main(String[] args) {

        String arr[] = {"zebra", "dog", "duck", "dove"};
        findShortestUniquePrefixForEveryWord(arr);


    }

}
