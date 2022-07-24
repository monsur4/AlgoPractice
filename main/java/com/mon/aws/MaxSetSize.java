package com.mon.aws;

import java.util.*;

public class MaxSetSize {

    public static int maxSetSize(List<Integer> set){
        set.sort(Comparator.comparingInt(a -> a));

        Map<Integer, Integer> solSet = new HashMap<>();

        int max = -1;
        int largestEl = Collections.max(set);

        for(int n=0, val=set.get(n);  val*val<=largestEl; n++, val=set.get(n)){
            int presentEl = val * val;
            if(set.contains(presentEl)){
                int count = -1;
                if(solSet.get(val) == null){
                    count = 2;
                }else{
                    count = solSet.get(val) + 1;
                }
                solSet.put(presentEl, count);
                if(count > max){
                    max = count;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
//        int sol = MaxSetSize.maxSetSize(List.of(625, 4, 2, 5, 25));
        int sol = MaxSetSize.maxSetSize(Arrays.asList(625, 4, 2, 5, 25));
        System.out.println("sol = " + sol);
    }
}
