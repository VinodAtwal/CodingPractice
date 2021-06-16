package com.test.question.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static java.util.stream.Collectors.toMap;

class Word {
    char c;
    int freq;

    public Word(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "Word{" +
                "c='" + c + '\'' +
                ", freq=" + freq +
                '}';
    }
}

public class Q6_ReorganizeString {

    public static boolean reorganizeWordsOptimal(String input) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        Map<Character, Integer> hashmap = input.chars().boxed().collect(toMap(
                // key = char
                k -> (char) k.intValue(),
                v -> 1,         // 1 occurence
                Integer::sum)); // counting

        PriorityQueue<Word> maxHeap = new PriorityQueue<>((i, j) -> j.freq - i.freq);
        hashmap.keySet().forEach(i -> maxHeap.add(new Word(i, hashmap.get(i))));

        Word prev = new Word('#', -1);
        String op = "";
        while (!maxHeap.isEmpty()) {
            Word curr = maxHeap.poll();
            op += curr.c;

            if (prev.freq > 0) {
                maxHeap.add(prev);
            }
            curr.freq--;
            prev = curr;
        }
        if (op.length() == input.length()) {
            System.out.println(op);
        }
        return op.length() == input.length();

    }

    public static boolean reorganizeWords(String input) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        Map<Character, Integer> hashmap = input.chars().boxed().collect(toMap(
                // key = char
                k -> (char) k.intValue(),
                v -> 1,         // 1 occurence
                Integer::sum)); // counting

        PriorityQueue<Word> maxHeap = new PriorityQueue<>((i, j) -> j.freq - i.freq);
        hashmap.keySet().forEach(i -> maxHeap.add(new Word(i, hashmap.get(i))));

        Word temp = null;
        String op = "";
        while (!maxHeap.isEmpty()) {
            if (op.isEmpty() || (maxHeap.peek().c != op.charAt(op.length() - 1))) {
                Word w = maxHeap.poll();
                op += w.c;

                w.freq--;
                if (w.freq > 0) {
                    maxHeap.add(w);
                }
                if (temp != null) {
                    maxHeap.add(temp);
                    temp = null;
                }
            } else {
                temp = maxHeap.poll();
            }
        }

        if (op.length() == input.length()) {
            System.out.println(op);
        }
        return op.length() == input.length();


    }

    public static void main(String[] args) {
        String s = "aaaabb";
        System.out.println(reorganizeWords(s));

    }


}
