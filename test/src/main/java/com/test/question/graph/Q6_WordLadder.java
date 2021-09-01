package com.test.question.graph;

import java.util.*;

public class Q6_WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String origWord = queue.poll();
                char[] wordArr = origWord.toCharArray();
                for (int i = 0; i < wordArr.length; i++) {
                    char original = wordArr[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (wordArr[i] == j) {
                            continue;
                        }
                        wordArr[i] = j;
                        String newWord = String.valueOf(wordArr);
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (set.contains(newWord)) {
                            queue.add(newWord);
                            set.remove(newWord);
                        }

                    }
                    wordArr[i] = original;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] arr = {"hot", "dot", "dog", "lot", "log"};
        String start = "hit";
        String end = "cog";
        System.out.println(ladderLength(start, end, Arrays.asList(arr)));

    }
}
