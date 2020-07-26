package com.fq.lc.dp;

/**
 * 假设有个小偷，它有一个包容量为y，它要拿走别人的东西，
 * 但是东西有价值与容量属性，如何保证在y容量内拿到最大的价值呢？
 *
 * @author lgq
 * @date 2020/7/26
 */
public class 背包问题01 {

    public int maxValue(int[] capacity, int[] value, int totalCapacity) {
        int length = capacity.length;
        int[][] dp = new int[length][totalCapacity + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j - capacity[j] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - capacity[j]] + value[j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[capacity.length - 1][totalCapacity];
    }

}
