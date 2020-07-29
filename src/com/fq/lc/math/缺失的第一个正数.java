package com.fq.lc.math;

/**
 * @author muXue
 * @date 2020/7/29 20:53
 */
public class 缺失的第一个正数 {


    public int firstMissingPositive(int[] nums) {
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] < max) {
                max = nums[i];
            }
        }
        if (max > 1) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {

        }
    }

}
