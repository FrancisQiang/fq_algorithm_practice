package com.fq.lc.doublepointer;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @author lgq
 * @date 2020/7/19
 */
public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // 首先固定一位
        for (int i = 0; i < nums.length - 2; i++) {
            int fixedNum = nums[i];
            // 如果当前数和前面一个相等则直接continue
            if (i > 0 && fixedNum == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = fixedNum + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> elementList = Arrays.asList(fixedNum, nums[j], nums[k]);
                    result.add(elementList);
                    // 下面去重 主要应对这种情况[-2,0,0,2,2]，[-2,0,0,1,2]
                    while(j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while(j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return result;
    }

}
