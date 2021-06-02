package com.test.question.trie;

import java.util.Arrays;

public class TrieNode {
    public int freq;
    public TrieNode[] children;
    public boolean isEndOfWord;

    public TrieNode() {
        this.freq =0;
        this.children = new TrieNode[26];
        this.isEndOfWord=false;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "children=" + Arrays.toString(children) +
                ", isEndOfWord=" + isEndOfWord +
                '}';
    }
}
