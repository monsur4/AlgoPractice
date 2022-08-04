package com.mon.aws;

/**
 * Time complexity: 0(N * N * N)
 * Space complexity: O(1)
 *
 * This my implementation loops through the input (N) in a nested for loop.
 * Therefore, when the size of N is low, this algorithm should run faster.
 * However, as N grows, this becomes significantly slow.
 */
public class MyMaxFreqDev {

    public static int getMaxFreqDeviation(String s) {
        int sol = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j < s.length(); j++){
                char firstChar = s.charAt(i);
                char secondChar = s.charAt(j);

                if(firstChar == secondChar) continue;

                int firstCharCount = 0;
                int secondCharCount = 0;
                boolean seenSecondChar=false;

                int maxDiff = 0;

                for(int index = i; index < s.length(); index++){  // you can actually start looping from j+1
                    char currentChar = s.charAt(index);
                    if(currentChar == firstChar) firstCharCount++;
                    if(firstCharCount == 0) continue; // if we haven't seen our firstChar yet then slide the window
                    if(currentChar == secondChar) secondCharCount++;


                    if(secondCharCount > 0){
                        int diff = firstCharCount - secondCharCount;
                        if(diff == 0){
                            firstCharCount = 0;
                            secondCharCount = 0;
                            seenSecondChar=true;
                        }
                        if(diff > maxDiff){
                            maxDiff = diff;
                        }
                    }else if(seenSecondChar){
                        int diff = Math.abs(firstCharCount - secondCharCount);

                        maxDiff = Math.max(maxDiff, diff);
                    }
                }

                sol = Math.max(sol, maxDiff);
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        // aaab
        // aaabb
        // abab
        // abbab
        // aabbab
        // aabb
        // aaabaaaa
        // aabbbb
        // abbbb
        String first = "bbacccabab"; //2
        String second = "aaaaa"; //0
        String third = "aabb"; //1
        String fourth = "abbab";//2
        String fifth = "aabbbb"; //3
        String sixth = "aabbbb"; //3


        System.out.println("first = " + MyMaxFreqDev.getMaxFreqDeviation(first));
        System.out.println("second = " + MyMaxFreqDev.getMaxFreqDeviation(second));
        System.out.println("third = " + MyMaxFreqDev.getMaxFreqDeviation(third));
        System.out.println("fourth = " + MyMaxFreqDev.getMaxFreqDeviation(fourth));
        System.out.println("fifth = " + MyMaxFreqDev.getMaxFreqDeviation(fifth));
        System.out.println("sixth = " + MyMaxFreqDev.getMaxFreqDeviation(sixth));

    }
}
