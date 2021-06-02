package com.test.question.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Q8_WordBreak {
    public static Set<String> hashSet;

    public static boolean wordBreak(String given, int index){
        boolean flag= false;
        if(index==given.length()){
            return true;
        }
        // if flag is true dont got for further recursion
        for (int i = index; i <= given.length() && !flag; i++) {
            if(hashSet.contains(given.substring(index,i))){
               flag= wordBreak(given,i) ;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String[] dict=
//                {"cats","dog","and","cat"};
                /*{"apple","pen"};*/
                { "i", "like", "sam", "sung", "samsung", "mobile",
                "ice","cream", "icecream", "man", "go", "mango" };
        String given=
//                "catsanddog";
//                "catsandog";
                //"applepenapple";
                "ilike";

        hashSet=Arrays.stream(dict).collect(Collectors.toSet());

        System.out.println(wordBreak(given,0));




    }


}
