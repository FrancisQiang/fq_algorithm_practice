package com.fq.lc.dp;

/**
 * @author lgq
 * @date 2020/6/7
 */
public class 爬楼梯 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

}
