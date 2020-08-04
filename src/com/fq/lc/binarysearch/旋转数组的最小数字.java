package com.fq.lc.binarysearch;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 * @author muXue
 * @date 2020/8/4 21:31
 */
public class 旋转数组的最小数字 {

    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        // 3 4 5 6 7 1 2
        // 一开始左边大于右边的
        while(numbers[i] > numbers[j]) {
            int mid = (j - i) / 2 + i;
            // 如果左边小于中间的 左边是递增 最小值肯定在右边
            if (numbers[i] < numbers[mid]) {
                i = mid + 1;
            } else {
                // 如果中间小于等于的 那么最小的肯定在最左边
                j = mid;
            }
        }
        return Math.min(numbers[i], numbers[i + 1]);
    }

}
