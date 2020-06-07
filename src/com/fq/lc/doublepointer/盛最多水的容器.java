package com.fq.lc.doublepointer;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * @author lgq
 * @date 2020/6/7
 */
public class 盛最多水的容器 {

    public int maxArea(int[] height) {
        // 双指针 贪心思想
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; j > i;) {
            maxArea = Math.max(Math.min(height[i],height[j]) * (j - i), maxArea);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

}
