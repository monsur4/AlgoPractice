package com.mon.implementation;

import java.util.HashMap;
import java.util.Map;

public class Connected {

    public static String connect(String[] inputs){
        int[] charArr = new int[128];
        Map<Character, String> map = new HashMap<>();

        // building the datastructures
        for(String s: inputs){
            char firstChar = s.charAt(0);
            char secondChar = s.charAt(2);

            // connect them in the arr
            charArr[firstChar] = secondChar;

            // input both chars into the map or delete if it already exists
            // helps to determine the first character in the final string
            if(map.containsKey(firstChar)){
                map.remove(firstChar);
            }else{
                // S for a start character
                map.put(firstChar, "S");
            }

            if(map.containsKey(secondChar)){
                map.remove(secondChar);
            }else{
                // E for the end character
                map.put(secondChar, "E");
            }
        }

        // determine the first character
        int next = -1;
        for(char c: map.keySet()){
            if (map.get(c).equals("S")){
                next = c;
                break;
            }
        }

        // solution string
        StringBuilder sb = new StringBuilder();
        sb.append((char)next);
        while(charArr[next] != 0){
            next = charArr[next];
            sb.append((char)next);
        }
        return sb.toString();
    }

    public static void main(String... args){
        //["S>P", "P>A", "A>I", "I>N"]
        String[] entry1 = {"P>E", "E>R", "R>U"};
        String[] entry2 = {"I>N", "A>I", "P>A", "S>P"};
        String[] entry3 = {"U>N", "G>A", "R>Y", "H>U", "N>G", "A>R"};
        String[] entry4 = {"I>F", "W>I", "S>W", "F>T"};
        String[] entry5 = {"R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"};
        String[] entry6 = {"W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"};
        String[][] entries = {entry1, entry2, entry3, entry4, entry5, entry6};
        for(String[] entry: entries){
            System.out.println(connect(entry));
        }
    }
}
