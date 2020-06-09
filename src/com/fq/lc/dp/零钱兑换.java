package com.fq.lc.dp;

import java.util.Arrays;

/**
 * @author lgq
 * @date 2020/6/9
 */
public class 零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 首先初始化 代表对于所有的数值都需要 amount + 1 这是最大值
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    // 动归公式 dp[i] = dp[i - coins[j]] + 1
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
