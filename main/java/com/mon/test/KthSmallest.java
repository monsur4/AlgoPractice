package com.mon.test;

import java.util.*;

public class KthSmallest {

    public static void main(String[] args) {
        goodArr();
    }


    public static void goodArr(){
        int N = 1_000_000_000;
        int i = 1;
        List<Integer> goodArr = new ArrayList<>();

        while(N > 0){
            while(i*2 <= N){
                i *= 2;
            }
            goodArr.add(i);
            N = N - i;
            i=1;
        }
        Collections.sort(goodArr);
        System.out.println("goodArr = " + goodArr);
    }
}
