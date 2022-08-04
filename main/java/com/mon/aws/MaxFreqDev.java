package com.mon.aws;

/**
 * Time complexity: O(26 * 26 * N) = O(N)
 * Space complexity: O(1)
 *
 * NB: If you can guarantee that a nested for loop will run for a fixed
 * amount of time, then you can guarantee that your algorithm's
 * time complexity will not be affected.
 * -this could mean that this implementation may be slower when the
 * input size (N) is low. But in terms of order of growth,
 * this algorithm has a linear time complexity and should pay off as N grows
 */
public class MaxFreqDev {

    public static int getMaxFreqDeviation(String s) {
        int sol = 0;
        for (char hiFreqChar = 'a'; hiFreqChar <= 'z'; hiFreqChar++) {
            for (char loFreqChar = 'a'; loFreqChar <= 'z'; loFreqChar++) {
                if (hiFreqChar != loFreqChar) {
                    int hiFreqCharCount = 0;
                    int loFreqCharCount = 0;

                    boolean isLoFreqCharAbandoned = false;

                    for (char c : s.toCharArray()) {
                        if (c == hiFreqChar) hiFreqCharCount++;
                        if (c == loFreqChar) loFreqCharCount++;

                        if (loFreqCharCount > 0) {
                            sol = Math.max(sol, hiFreqCharCount - loFreqCharCount);
                        } else {
                            // Edge case: there are no `lowFreqChar` in current interval.
                            // In case if we re-started Kadane algo calculation -
                            // we can "extend" current interval with 1 previously abandoned 'lowFreqChar'
                            if (isLoFreqCharAbandoned) {
                                sol = Math.max(sol, hiFreqCharCount - 1);
                            }
                        }

                        if (loFreqCharCount > hiFreqCharCount) {
                            // Kadane's algo calculation re-start: abandon previous chars and their freqs.
                            // Important: the last abandoned char is the `lowFreqChar` - this can be used on further iterations.
                            loFreqCharCount = 0;
                            hiFreqCharCount = 0;
                            isLoFreqCharAbandoned = true;
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
