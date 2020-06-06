package com.fq.sort;

/**
 * @author lgq
 * @date 2020/6/6
 */
public class HeapSort {

    public static void heapSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            siftDown(nums, i);
        }
    }

    private static int leftChild(int index) {
        return index * 2 + 1;
    }

    private static int rightChild(int index) {
        return index * 2 + 2;
    }

    private static void siftDown(int[] nums, int i) {
        while(i > 0 && leftChild(i) < nums.length) {
            int j = leftChild(i);
            // 判断左右孩子节点的大小 如果右孩子大于左孩子 那么和右孩子交换
            if (j + 1 < nums.length && nums[j + 1] > nums[j]) {
                j++;
            }
            // 如果父节点已经比两个孩子都大了那么就不交换了
            if (nums[i] > nums[j]) {
                break;
            }
            SortUtils.swap(nums, i, j);
            // 继续循环交换
            i = j;
        }
    }


}
