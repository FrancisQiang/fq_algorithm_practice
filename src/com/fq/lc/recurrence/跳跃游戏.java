package com.fq.lc.recurrence;

/**
 * @author lgq
 * @date 2020/9/6
 */
public class 跳跃游戏 {


    // 贪心

//    public boolean canJump(int[] nums) {
//        int n = nums.length;
//        int rightmost = 0;
//        for (int i = 0; i < n; ++i) {
//            if (i <= rightmost) {
//                rightmost = Math.max(rightmost, i + nums[i]);
//                if (rightmost >= n - 1) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    private boolean[] visited;
    private int[] nums;

    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        visited = new boolean[nums.length];
        this.nums = nums;
        return helper(0);
    }

    private boolean helper(int index) {
        if (index == nums.length - 1) {
            return true;
        }
        if (index < nums.length && !visited[index]) {
            int skipLength = nums[index];
            visited[index] = true;
            for (int i = 1; i <= skipLength; i++) {
                if (helper(index + i)) {
                    return true;
                }
            }
            visited[index] = false;
        }
        return false;
    }


}
