package com.fq.sort;

/**
 * @author lgq
 * @date 2020/6/6
 */
public class QuickSort {


    public static void quickSort3(int[] nums, int l, int r) {
        // 递归终止，如果左右边间相等或者右边界小于左边界则直接返回
        if (r <= l) {
            return;
        }
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        // 获取基准数 默认为第一个 但一般可以设置随机然后交换
        int base = nums[l];
        for (; i < gt ;) {
            // 当前数大于基准数
            if (nums[i] > base) {
                // 跟gt交换
                SortUtils.swap(nums, i, --gt);
            } else if (base == nums[i]) {
                i++;
            } else {
                SortUtils.swap(nums, i, ++lt);
                i++;
            }
        }
        SortUtils.swap(nums, lt, l);
        quickSort3(nums, l, lt - 1);
        quickSort3(nums, gt, r);
    }


}
