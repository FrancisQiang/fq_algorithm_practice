package com.fq.lc.dp;

/**
 * @author muXue
 * @date 2020/9/15 20:20
 */
public class 不同的子序列 {

    class Solution {
        public int numDistinct(String s, String t) {
            //s为空的情况
            if(s == null || s.length() == 0) return 0;
            //t为空的情况
            if(t == null || t.length() == 0) return s.length();

            int m = t.length() + 1, n = s.length() + 1;
            int[][] dp = new int[m][n];
            //数组第一行赋值为1
            for(int i = 0; i < n ; i++)
                dp[0][i] = 1;
            for(int i = 1; i < m; i++) {
                for(int j = i; j < n; j++) {
                    char a = t.charAt(i - 1), b = s.charAt(j - 1);
                    if(a == b)
                        dp[i][j] = dp[i][j - 1] +  dp[i - 1][j - 1] ;
                    else
                        dp[i][j] = dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }


}
