package com.test.question.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Q23_FirstNonRepeatingCharacterInStream {

    public static String getFirstNonRepeating(int[] charArray) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 0) {
                if (charArray[i] < min) {
                    min = charArray[i];
                    index = i;
                }
            }
        }

        return index == -1 ? "#" : "" + (char) (index + 'a');
    }

    public static String firstNonRepeatingCharacterInStream(String input) {
        int character[] = new int[26];
        int count = 1;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int index = c - 'a';
            if (character[index] == 0) {
                character[index] = count;
                ++count;
            } else {
                character[index] = -1;
            }
            output.append(getFirstNonRepeating(character));
        }
        return output.toString();
    }

    public static String firstNonRepeatingCharacterInStreamQueue(String input) {
        int[] character = new int[26];
        Queue<Character> queue = new LinkedList<>();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int index = c - 'a';
            ++character[index];
            if (character[index] < 2) {
                queue.add(c);
            }
            while (!queue.isEmpty() && character[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
            output.append(queue.isEmpty() ? "#" : queue.peek());
        }
        return output.toString();

    }

    public static void main(String[] args) {
        String s = "aabc";
        String s1 = "geeksforgeeksandquizfor";
        String s2 = "abcdcdab";
        String s3 = "aaaaaaaa";
        System.out.println(firstNonRepeatingCharacterInStream(s3));
        System.out.println(firstNonRepeatingCharacterInStreamQueue(s3));


    }

}
