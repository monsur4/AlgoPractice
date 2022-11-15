package com.mon.andela.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestNumbers {
    public static void closestNumbers(List<Integer> numbers){
        Collections.sort(numbers);
        int minAbsDiff = Integer.MAX_VALUE;
        List<Integer> solution = new ArrayList<>();
        for(int i=1; i<numbers.size(); i++){
            int first = numbers.get(i-1);
            int second = numbers.get(i);
            int diff = second - first;

            if(diff < minAbsDiff){
                solution = new ArrayList<>();
                solution.add(i);
                minAbsDiff = diff;
            }else if(diff == minAbsDiff){
                solution.add(i);
            }
        }

        for(int i=0; i< solution.size(); i++){
            int index = solution.get(i);
            System.out.println(numbers.get(index -1) + " " +  numbers.get(index));
        }
    }
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(6, 2, 4, 10 , 14, 16);
        closestNumbers(integers);
        // solution
        // 2 4
        // 4 6
        // 14 16
    }
}
