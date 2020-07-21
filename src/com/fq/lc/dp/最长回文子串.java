package com.fq.lc.dp;

/**
 * @author lgq
 * @date 2020/7/21
 */
public class 最长回文子串 {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int begin = 0;
        int maxLength = 1;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

//    public String longestPalindrome(String s) {
//        // 特判
//        int len = s.length();
//        if (len < 2) {
//            return s;
//        }
//
//        int maxLen = 1;
//        int begin = 0;
//
//        // dp[i][j] 表示 s[i, j] 是否是回文串
//        boolean[][] dp = new boolean[len][len];
//        char[] charArray = s.toCharArray();
//
//        for (int i = 0; i < len; i++) {
//            dp[i][i] = true;
//        }
//        for (int j = 1; j < len; j++) {
//            for (int i = 0; i < j; i++) {
//                if (charArray[i] != charArray[j]) {
//                    dp[i][j] = false;
//                } else {
//                    if (j - i < 3) {
//                        dp[i][j] = true;
//                    } else {
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                }
//
//                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
//                if (dp[i][j] && j - i + 1 > maxLen) {
//                    maxLen = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLen);
//    }

}
