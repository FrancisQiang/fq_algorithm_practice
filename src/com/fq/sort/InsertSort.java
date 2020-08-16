package com.fq.sort;

/**
 * @author lgq
 * @date 2020/6/6
 */
public class  InsertSort {

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1] ; j--) {
                SortUtils.swap(nums, j, j -1);
            }
        }
    }

}
