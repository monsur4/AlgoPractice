package com.mon.knowledgeSharing;


// find the index of 35 = 28
// find the index of 82 =
// find the index of 62 = -1
// find the index of 3 = 1
// find the index of 97 = 78


public class BinarySearchDemo {
    // TODO Problem: given a list of numbers in ascending (non-descending) order, find the index of a number x
    static int[] input2 = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10}; // 4
    int num = 5/2; // 2

    static int[] input3 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}; // 5
    static int[] input4 = new int[]{2, 4, 5, 7, 9, 11}; // 2
    // TODO find the index of the number 5;

    static int[] input1 = new int[]{1, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 15, 16, 17, 18, 19,
            20, 22, 23, 24, 25, 26, 28, 29,
            30, 31, 33, 34, 35, 36, 37, 38,
            41, 42, 43, 45, 46, 47, 48, 49,
            50, 51, 52, 53, 54, 56, 58, 59,
            60, 61, 63, 64, 65, 66, 67, 69,
            70, 71, 73, 74, 75, 76, 78, 79,
            80, 81, 82, 83, 86, 87, 88, 89,
            90, 92, 93, 94, 95, 96, 97, 98,
            100};

    public static int binarySearch(int[] arr, int val){
        int lo = 0;
        int hi = arr.length - 1;

        while(lo <= hi){
            int mid = (lo + hi)/ 2;
            if(arr[mid] == val){
                return mid;
            }else if(val > arr[mid]){
                lo = mid + 1;
            }else if (val < arr[ mid]){
                hi = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        long start = System.nanoTime();
//        for(int i=0; i<input1.length; i++){
//            if(input1[i] == 3){
//                System.out.println(i);
//            }
//        }
        int ans = binarySearch(input1, 5);
        long end = System.nanoTime();
        System.out.println("Time - " + (end-start) + " milliseconds" + "\n answer is - " + ans);
    }


    // find the index of 3
    // find the index of 97
    // find the index of 35
    // find the index of 82
    // find the index of 62



    // TODO : 1) Naive Search (linear search from left || linear search from right || random search)
    // TODO : 2) Binary Search
    // TODO : 3) Time Complexity O(N) vs O(lgN)
}
