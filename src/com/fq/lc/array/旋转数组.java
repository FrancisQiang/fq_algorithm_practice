package com.fq.lc.array;

/**
 * @author muXue
 * @date 2020/9/15 16:20
 */
public class 旋转数组 {

    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        for (int i = 0; i < k; i++) {
            int pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }

}
