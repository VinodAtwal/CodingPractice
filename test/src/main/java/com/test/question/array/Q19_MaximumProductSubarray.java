package com.test.question.array;

/*

{-6, 3, -10,0, -99, 100, 2, 4}

min = -6 => -6*3, 3 => -18 => Swap(3) => 3 * -10, -10 => -30 => -30 * 0, 0 => 0
max = -6 => -6*3, 3 => 3 => Swap(-18) => -18 * -10 , -10 => 180  => 180 * 0, 0 => 0
maxProduct = -6 => 3=> 180 =>


max(curr, max * curr);


1) Swap if negative
2) Max----> min ?? ---> save min to use it in future if we get negative value again
3) New Subarray handling---- > checking currently processed max and min cursors with current value is handling new subarray value
*/
public class Q19_MaximumProductSubarray {

    public static Long maximumProductSubArray(Long[] arr){
        Long max=arr[0];
        Long min= arr[0];
        Long product= arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]<0){
                Long temp= min;
                min=max;
                max=temp;
            }
            max= Math.max(arr[i],max*arr[i]);
            min=Math.min(arr[i],min*arr[i]);
            product=Math.max(product,max);
        }
        return product;
    }

    public static void main(String[] args) {
        Long[] arr= {6L, -3L, -10L, 0L, 2L};

        System.out.println(maximumProductSubArray(arr));
    }
}
