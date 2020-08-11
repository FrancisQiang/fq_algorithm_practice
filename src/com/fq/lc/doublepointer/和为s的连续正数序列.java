package com.fq.lc.doublepointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * @author muXue
 * @date 2020/8/11 15:46
 */
public class 和为s的连续正数序列 {

    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        int[] nums = new int[target + 1];
        for(int i = 1; i < nums.length; i++) {
            nums[i] = i;
        }
        int curNum = 1;
        for(int left = 1, right = 1;;) {
            if (left == right && left != 1) {
                break;
            }
            if(curNum < target) {
                curNum += nums[++right];
            } else if(curNum > target) {
                curNum -= nums[left];
                left++;
            } else {
                int[] subArray = new int[right - left + 1];
                for(int k = left, l = 0; k <= right; k++, l++) {
                    subArray[l] = k;
                }
                result.add(subArray);
                curNum += nums[++right];
            }
        }
        int[][] out = new int[result.size()][];
        return result.toArray(out);
    }

}
