package com.mon.knowledgeSharing;

public class BinarySearch {

    public static int binarySearch(int[] arr, int val){
        int lo = 0;
        int hi = arr.length-1;

        while(lo<=hi){
            int mid = (lo + hi)/2;
            if(val == arr[mid]){
                return mid;
            }else if(val < arr[mid]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static int naiveSearch(int[] arr, int val){
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == val) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
                30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
                40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
                50, 51, 52, 53, 54, 55, 56, 57, 58, 59,
                60, 61, 62, 63, 64, 65, 66, 67, 68, 69,
                70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
                80, 81, 82, 83, 84, 85, 86, 87, 88, 89,
                90, 91, 92, 93, 94, 95, 96, 97, 98, 99,
                100};

        int val = 97;

        int total =0;
        int answer = -1;
        for (int i =0; i<100; i++){
            long start = System.nanoTime();
            answer = naiveSearch(input1, val);
            long end = System.nanoTime();
            total+=(end - start);
        }
        total /= 100;
        System.out.println("With naive search >>> Answer is - " + answer + " and was found in " + total + " milliseconds");

        total =0;
        answer = -1;
        for (int i =0; i<100; i++){
            long start = System.nanoTime();
            answer = binarySearch(input1, val);
            long end = System.nanoTime();
            total+=(end - start);
        }
        total /= 100;
        System.out.println("With binary search >>> Answer is - " + answer + " and was found in " + total + " milliseconds");

    }
}
