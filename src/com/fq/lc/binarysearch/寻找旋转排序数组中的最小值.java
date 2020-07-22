package com.fq.lc.binarysearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * @author muXue
 * @date 2020/7/22 17:59
 */
public class 寻找旋转排序数组中的最小值 {

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int i = 0, j = nums.length - 1;
        while(nums[j] < nums[i]) {
            int mid = (j + i) / 2;
            if (nums[i] < nums[mid]) {
                i = mid;
            } else {
                j = mid;
            }
        }
        return Math.min(nums[i], nums[i + 1]);
    }

}
