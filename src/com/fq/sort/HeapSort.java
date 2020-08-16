package com.fq.sort;

import java.util.Arrays;

/**
 * @author lgq
 * @date 2020/6/6
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4,6,8,3,5,9};
        sort(nums);
        SortUtils.print(nums);
    }

    public static void sort(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            siftDown(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j >= 0; j--) {
            SortUtils.swap(arr, 0, j);
            siftDown(arr, 0, j);
        }

    }

    private static int left(int index) {
        return index * 2 + 1;
    }


    public static void siftDown(int[] arr, int i, int size) {
        while (left(i) < size) {
            int j = left(i);
            if (j + 1 < size && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[i] > arr[j]) {
                break;
            }
            SortUtils.swap(arr, i, j);
            i = j;
        }
    }

}