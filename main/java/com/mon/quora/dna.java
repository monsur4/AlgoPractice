package com.mon.quora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dna {
    public static void Solve(int n, String seq){
        int k = -1;
        int m = 0;
        for(int i = 1; i<n; i++){
            int l = i-1;
            int r = i;
            int count = 0;
            while(l>=0 && r<n){
                // System.out.println(i + "-" + l);
                if(count>n-i){
                    System.out.println(k + " " + m);
                    return;
                }
                if(complement(seq.charAt(l), seq.charAt(r))){
                    count++;
                }
                --l;
                ++r;
            }
            if(count > m){
                m = count;
                k = i;
            }
        }
        System.out.println(k + " " + m);
    }

    private static boolean complement(char c, char d){
        if(c == 'A') return d == 'T';
        if(c == 'T') return d == 'A';
        if(c == 'G') return d == 'C';
        if(c == 'C') return d == 'G';
        return false;
    }

    public static void main(String... args){
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = -1;
        String seq = "";
        try {
            n = Integer.parseInt(b.readLine());
            seq = b.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Solve(n, seq);
    }
}
