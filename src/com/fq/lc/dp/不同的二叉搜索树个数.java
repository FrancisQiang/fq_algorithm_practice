package com.fq.lc.dp;

/**
 * @author muXue
 * @date 2020/8/11 17:49
 */
public class 不同的二叉搜索树个数 {

    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] +
            }
        }

    }

}
