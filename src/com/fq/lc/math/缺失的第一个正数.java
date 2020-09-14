package com.fq.lc.math;

/**
 *
 *
 * @author muXue
 * @date 2020/7/29 20:53
 */
public class 缺失的第一个正数 {

    // 遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，
    //然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，
    //否则遍历完都没出现那么答案就是数组长度加1。
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
