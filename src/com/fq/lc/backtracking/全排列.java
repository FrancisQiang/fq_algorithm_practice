package com.fq.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例：输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @author lgq
 * @date 2020/6/7
 */
public class 全排列 {

    private List<List<Integer>> result = new ArrayList<>();

    private int[] nums;

    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        this.nums = nums;
        this.visited = new boolean[nums.length];
        helper(new ArrayList<>());
        return result;
    }

    private void helper(List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 从头开始遍历
        for (int i = 0; i < nums.length; i++) {
            // 如果没有被访问过，则添加进结果
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                helper(list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }


}
