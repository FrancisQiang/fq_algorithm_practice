package com.fq.lc.recurrence;

/**
 *
 * @author lgq
 * @date 2020/8/12
 */
public class 正则表达式匹配 {

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean match = text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.';
        if (pattern.length() > 2 && pattern.charAt(1) == '*') {
            // 匹配0个
            boolean match0 = isMatch(text, pattern.substring(2));
            boolean matchMore = match && isMatch(text.substring(1), pattern);
            return match0 || matchMore;
        }
        return match && isMatch(text.substring(1), pattern.substring(1));
    }


    // 动态规划解法

    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();

            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 0; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (p.charAt(j - 1) == '*') {
                        // 首先匹配0个
                        boolean match0 = dp[i][j - 2];
                        boolean matchAny = false;
                        // 如果匹配字符串*前面的字符和当前的s的比较 是相等 则需要进一步判断
                        if (matches(s, p , i, j - 1)) {
                            matchAny = dp[i - 1][j];
                        }
                        dp[i][j] = match0 || matchAny;
                    } else {
                        if (matches(s, p, i, j)) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }

            }
            return dp[m][n];
        }

        public boolean matches(String s, String p, int i, int j) {
            // 如果i=0直接false
            if (i == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }



}
