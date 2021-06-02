package com.test.question.string;

public class Q7_EditDistance {

    public static int minOperation= Integer.MAX_VALUE;

    public static void editDistance(String s1,String s2,int index1,int index2,int operation){
        while (index1<s1.length() && index2<s2.length())
        {
            if(s1.charAt(index1)==s2.charAt(index2)){
                index1++;
                index2++;
            }else{
               /*   //insert
                editDistance(s1,s2,index1,index2+1,operation+1);
                //remove
                editDistance(s1,s2,index1+1,index2,operation+1);
                //replace
                editDistance(s1,s2,index1+1,index2+1,operation+1);*/

               //insert
                editDistance(s1.substring(0,index1) + s2.charAt(index2) + s1.substring(index1),s2,index1+1,index2+1,operation+1);
                //remove
                editDistance(s1.substring(0,index1) + s1.substring(index1+1),s2,index1,index2,operation+1);
                //replace
                editDistance(s1.substring(0,index1) + s2.charAt(index2)+s1.substring(index1+1),s2,index1+1,index2+1,operation+1);
                return;
            }
        }

        minOperation=Math.min(minOperation,operation+Math.abs(s1.length()-s2.length()));

       /* minOperation=Math.min(minOperation,operation+Math.abs((s1.length()-index1) -(s2.length()-index2)));*/
    }

    public static void main(String[] args) {


        String s1="abcdefgh";
        String s2="adefghxd";
        editDistance(s1,s2,0,0,0);
        System.out.println(minOperation);
    }
}
