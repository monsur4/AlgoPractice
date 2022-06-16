package com.mon.sort;

public class SelectionSort {

    public static void sort(int[] arr){
        for(int i=0; i< arr.length; i++){
            int nextSmallestIndex = i;
            for(int j = i+1; j< arr.length; j++){
                if(arr[j] < arr[nextSmallestIndex]){
                    nextSmallestIndex = j;
                }
            }
            // no need to call swap if element i is in its right position => for efficiency
            if(i == nextSmallestIndex) continue;
            swap(arr, i, nextSmallestIndex);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int elementI = arr[i];
        int elementJ = arr[j];

        arr[i] = elementJ;
        arr[j] = elementI;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,1,3,2,0,-1,7,10,1,9,20};
        sort(array);
        for(int el: array){
            System.out.println(el);
        }
    }
}
