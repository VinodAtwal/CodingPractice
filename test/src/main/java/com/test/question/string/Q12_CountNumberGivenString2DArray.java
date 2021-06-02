package com.test.question.string;

public class Q12_CountNumberGivenString2DArray {
    public static String[] input=
            {       "DDDGDD",
                    "BBDEBS",
                    "BSKEBK",
                    "DDDDDE",
                    "DDDDDE",
                    "DDDDDG"

            };
//            { "BBABBM", "CBMBBA",
//            "IBABBG", "GOZBBI",
//            "ABBBBC", "MCIGAM" };

    public static int findGivenStringIn2DArray(String ip, int index, int prevx, int prevy , int x, int y ){
            if(index==ip.length()-1){
                return 1;
            }
            int count=0;
                //--> left iteration
                if( y-1>=0 && y-1!=prevy && input[x].charAt(y-1)==ip.charAt(index+1)){
                    //prevy=y;
                    count+= findGivenStringIn2DArray(ip,index+1,prevx,y,x,y-1);
                }
                //-->right iteration
                if( y+1<input[0].length() && y+1!=prevy && input[x].charAt(y+1)==ip.charAt(index+1)){
                    //prevy=y;
                    count+= findGivenStringIn2DArray(ip,index+1,prevx,y,x,y+1);
                }
                //-->  top iteration
                if( x-1>=0 && x-1!=prevx && input[x-1].charAt(y)==ip.charAt(index+1)){
                    //prevx=x;
                    count+= findGivenStringIn2DArray(ip,index+1,x,prevy,x-1,y);
                }
                //bottom iteration
                if(x+1<input.length && x+1!=prevx &&input[x+1].charAt(y)==ip.charAt(index+1) ){
//                    prevx=x;
                    count+= findGivenStringIn2DArray(ip,index+1,x,prevy,x+1,y);
                }

                return count;


    }

    public static int countNumberOfGivenStringIn2DArray(String ip){
        int count=0;
        for (int i = 0; i <input.length ; i++) {
            for (int j = 0; j <input[0].length() ; j++) {
                if(input[i].charAt(j)==ip.charAt(0)){
                    count+=findGivenStringIn2DArray(ip,0,-1,-1,i,j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s="BDKE";
//                "GEEKS";
//                "MAGIC";
        System.out.println(countNumberOfGivenStringIn2DArray(s));

    }
}
