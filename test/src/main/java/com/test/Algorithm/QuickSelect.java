package com.test.Algorithm;


import com.test.Utility.Utility;

//QuickSelect is a selection algorithm to find the k-th smallest/largest element in an unordered list
public class QuickSelect {

    public static int partition(int[] arr, int low,
                                int high)
    {
        int pivot = arr[high], pivotloc = low;
        for (int i = low; i <= high; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[pivotloc];
                arr[pivotloc] = temp;
                pivotloc++;
            }
        }
        int temp = arr[high];
        arr[high] = arr[pivotloc];
        arr[pivotloc] = temp;

        return pivotloc;
    }

    public static int kthSmallest(int[] arr, int low,
                                  int high, int k)
    {
        int partition = partition(arr, low, high);
        if (partition == k - 1)
            return arr[partition];
        else if (partition < k - 1)
            return kthSmallest(arr, partition + 1, high, k);
        else
            return kthSmallest(arr, low, partition - 1, k);
    }

    public static int partition(Integer[] arr, Integer l, Integer h){
        Integer piviotLoc = l;
        //arr[high]==>piviot

        for(int i=l;i<=h;i++){
            if(arr[i]<arr[h]){
                Utility.swap(arr,i,piviotLoc);
                piviotLoc++;
            }

        }
        Utility.swap(arr,h,piviotLoc);
        return piviotLoc;
    }

    public static  Integer kthlargest(Integer arr[], Integer l, Integer h, Integer k){

        Integer piviot = partition(arr,l,h);
        if(piviot== arr.length-k){
            return arr[piviot];
        }else if(piviot < arr.length-k){
            return kthlargest(arr,piviot+1,h,k);
        }else{
            return  kthlargest(arr,l,piviot-1,k);
        }

    }


    public static int partitionLargestDecending(Integer[] arr, Integer l, Integer h){
        Integer piviotLoc = l;
        //arr[high]==>piviot

        for(int i=l;i<=h;i++){
            if(arr[i]>arr[h]){
                Utility.swap(arr,i,piviotLoc);
                piviotLoc++;
            }

        }
        Utility.swap(arr,h,piviotLoc);
       // System.out.println("->"+piviotLoc);
        return piviotLoc;
    }

    public static  Integer kthlargestDecending(Integer arr[], Integer l, Integer h, Integer k){

        Integer piviot = partitionLargestDecending(arr,l,h);
        if(piviot== k-1){
            return arr[piviot];
        }else if(piviot < k-1){
            return kthlargestDecending(arr,piviot+1,h,k);
        }else{
            //System.out.println(piviot+" "+(k-1));
            return  kthlargestDecending(arr,l,piviot-1,k);
        }

    }




    public static void main(String[] args) {

        Integer arr[] ={5,1,3,8,2,4};
        Integer k=3;

//        System.out.println(kthlargest(arr,0,arr.length-1,k));
        System.out.println(kthlargestDecending(arr,0,arr.length-1,k));

    }
}
