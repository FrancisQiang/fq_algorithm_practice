package com.fq.sort;

import java.util.Random;

/**
 * @author lgq
 * @date 2020/6/6
 */
public class SortUtils {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void print(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num).append(",");
        }
        System.out.println(stringBuilder);
    }

    private static int[] randomArray(int capacity) {
        int[] nums = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            Random random = new Random();
            nums[i] = random.nextInt(capacity);
        }
        return nums;
    }


}
