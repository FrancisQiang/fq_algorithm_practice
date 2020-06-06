package com.fq.sort;

/**
 * @author lgq
 * @date 2020/6/6
 */
public class ChooseSort {

    public static void chooseSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            SortUtils.swap(nums, minIndex, i);
        }
    }


}
