package com.fq.sort;

/**
 * @author lgq
 * @date 2020/6/6
 */
public class MergeSort {

    public static void mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (r - l) / 2 + l;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, r, mid);
    }

    private static void merge(int[] nums, int l, int r, int mid) {
        // 创建一个新数组用来存储
        int[] newNums = new int[r - l + 1];
        int lIndex = l;
        int rIndex = mid + 1;
        for (int i = 0; i < newNums.length; i++) {
            if (lIndex == mid + 1) {
                newNums[i] = nums[rIndex];
                rIndex++;
                continue;
            } else if (rIndex == r + 1) {
                newNums[i] = nums[lIndex];
                lIndex++;
                continue;
            }
            if (nums[lIndex] < nums[rIndex]) {
                newNums[i] = nums[lIndex];
                lIndex++;
            } else {
                newNums[i] = nums[rIndex];
                rIndex++;
            }
        }
        if (newNums.length >= 0) {
            System.arraycopy(newNums, 0, nums, l, newNums.length);
        }
    }


}
