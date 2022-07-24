package com.mon.aws;

public class MaxFreqDev {

    public static int getMaxFreqDeviation(String s) {
        int sol = 0;
        for (char hiFreqChar = 'a'; hiFreqChar <= 'z'; hiFreqChar++) {
            for (char loFreqChar = 'a'; loFreqChar <= 'z'; loFreqChar++) {
                if (hiFreqChar != loFreqChar) {
                    int hiFreqCharCount = 0;
                    int loFreqCharCount = 0;

                    boolean isLoFreqCharZero = false;

                    for (char c : s.toCharArray()) {
                        if (c == hiFreqChar) hiFreqCharCount++;
                        if (c == loFreqChar) loFreqCharCount++;

                        if (loFreqCharCount > 0) {
                            sol = Math.max(sol, hiFreqCharCount - loFreqCharCount);
                        } else if (isLoFreqCharZero) {
                            sol = Math.max(sol, hiFreqCharCount - 1);
                        }

                        if (loFreqCharCount > hiFreqCharCount) {
                            loFreqCharCount = 0;
                            hiFreqCharCount = 0;
                            isLoFreqCharZero = true;
                        }
                    }
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        String first = "bbacccabab"; //2
        String second = "aaaaa"; //0
        String third = "aabb"; //1

        System.out.println("first = " + MaxFreqDev.getMaxFreqDeviation(first));
        System.out.println("second = " + MaxFreqDev.getMaxFreqDeviation(second));
        System.out.println("third = " + MaxFreqDev.getMaxFreqDeviation(third));

    }
}
