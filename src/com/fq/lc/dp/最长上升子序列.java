package com.fq.lc.dp;

import java.util.Arrays;

/**
 * @author lgq
 * @date 2020/6/9
 */
public class 最长上升子序列 {

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    // 如果i位置大于 j位置 那么为 dp[i] = dp[j] + 1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
