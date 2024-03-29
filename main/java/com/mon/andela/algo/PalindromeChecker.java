package com.mon.andela.algo;

import java.util.List;

/**
 * @author Monsuru
 * @since Nov-13(Sun)-2022
 */
public class PalindromeChecker {
    public static String panlindromeChecker(String s, List<Integer> startIndex, List<Integer> endIndex, List<Integer> subs) {
        int n = s.length();
        int[][] dp = new int[26][n];
        for (int i = 0; i < 26; i++) {
            char presentChar = (char) ('a' + i);
            for (int j = 0; j < n; j++) {
                int isSameChar = (s.charAt(j) == presentChar) ? 1 : 0;
                if (j == 0) {
                    dp[i][j] = isSameChar;
                } else {
                    dp[i][j] = dp[i][j - 1] + (isSameChar);
                }
            }
        }
        String solution = "";
        for (int i = 0; i < subs.size(); i++) {
            int start = startIndex.get(i);
            int end = endIndex.get(i);
            int sub = subs.get(i);

            int allCount = 0;
            for (int k = 0; k < 26; k++) {
                // int occurrence = dp[k][start] - dp[k][end] + (s.charAt(end) == ('a' + k) ? 1 : 0);
                int occurrence = dp[k][end] - dp[k][start] + (s.charAt(start) == ('a' + k) ? 1 : 0);
                if (occurrence % 2 == 1)
                    allCount++;
            }
            int requiredSubs = allCount / 2;
            if (requiredSubs <= sub) {
                solution = solution + "1";
            } else {
                solution = solution + "0";
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        String sol = panlindromeChecker("cdecd", List.of(0, 0, 0, 0), List.of(0, 1, 2, 3), List.of(0, 1, 1, 0));
        System.out.println("sol = " + sol); // 1110
    }
}
