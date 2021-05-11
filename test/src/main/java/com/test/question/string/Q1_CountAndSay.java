package com.test.question.string;

import java.util.TreeSet;


public class Q1_CountAndSay {
    public static String countAndSay(Integer n){
        String outString="1";
        for (int i = 1; i <n ; i++) {
            StringBuilder curOut= new StringBuilder();
            Integer count=1;
            Character prev=outString.charAt(0);
            int j=1;
            while (j<outString.length()){
               if(outString.charAt(j)==prev){
                    ++count;
                }else{
                    curOut.append(count).append(prev);
                    count=1;
                    prev=outString.charAt(j);
                }
                j++;
            }
            curOut.append(count).append(prev);
            outString= curOut.toString();
        }
        return outString;

    }

    public static void main(String[] args) {
//        System.out.println(countAndSay(10));
        class A{
          public   int a;

            public A(int i) {
                this.a = i;
            }
        }
        A s1= new A(2);
        A s2= new A(1);

//        TreeSet<A> treeSet = new TreeSet((o1,j)->o1.a - j.a);
//        treeSet.add(s1);
//        treeSet.add(s2);
//        System.out.println(treeSet);

    }
}
