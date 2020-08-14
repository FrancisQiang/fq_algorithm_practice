package com.fq.lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * @author muXue
 * @date 2020/8/13 16:46
 */
public class 全排列II {

    private int[] nums;
    private List<List<Integer>> result = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);
        visited = new boolean[nums.length];
        helper(new ArrayList<>());
        return result;
    }

    private void helper(List<Integer> subList) {
        if (subList.size() == this.nums.length) {
            result.add(new ArrayList<>(subList));
        }
        for (int i = 0; i < this.nums.length; i++) {
            // 去重
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                subList.add(this.nums[i]);
                helper(subList);
                subList.remove(subList.size() - 1);
                visited[i] = false;
            }
        }
    }

}
