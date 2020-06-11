package com.fq.lc.binarysearch;

/**
 * @author lgq
 * @date 2020/6/11
 */
public class 二分查找 {

    public int search(int[] nums, int target) {
        int mid, left = 0, right = nums.length - 1;
        while(left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
