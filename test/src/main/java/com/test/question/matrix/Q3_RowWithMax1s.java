package com.test.question.matrix;

public class Q3_RowWithMax1s {

    public static int rowWithMax1s(int[][] arr){
        int row= arr.length;
        int col=arr[0].length;
        int firstRowFirst1s =col-1;
        int nthRowAns=-1;

        for (int i = 0; i < col; i++) {
            if(arr[0][i]==1){
                firstRowFirst1s=i;
                nthRowAns=0;
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            if( arr[i][firstRowFirst1s]==1){
                nthRowAns=i;
                while ( firstRowFirst1s>0 && arr[i][firstRowFirst1s-1]==1){
                    --firstRowFirst1s;
                }
            }
        }
        return nthRowAns;
    }

    public static void main(String[] args) {
        int[][] arr ={{0, 0, 0,0 },
                    {0, 0, 0, 1},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}};
        System.out.println(rowWithMax1s(arr));
    }
}
