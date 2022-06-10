package com.mon.dp;

import java.util.Stack;

public class Decibinary {
    static Stack<Integer> sol = new Stack<>();
    public static void gen(int d, int s, int v){
        if (s < 0 || s > 9*((1 << (d+1))-1)){
            return;
        }
        else if(s==0 && d==-1){
            sol.push(v);
        }
        else{
            for(int i = 0; i<=4; i++){
                gen(d-1, s-i*(1<<d), v*10+i);
            }
        }

    }



    public static void main(String[] args) {

//        int n = (1<<1 + 1) - 1;
////                - - - - -
////                1  0 0 0 0
////                16 8 4 2 1
//        System.out.println(n);

        for (int i = 0; i < 5; i++){
            gen(3, i, 0);
        }

        for (int n : sol) {
            System.out.println(n);
        }
    }
}
