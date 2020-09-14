package com.fq.lc.doublepointer;

/**
 * @author lgq
 * @date 2020/9/6
 */
public class 接雨水 {

    public int trap(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while(left <= right) {
            // 如果此时left最大值小于右边的 那么左边有效 然后从左到右可以信任左边 所以去left
            if (leftMax < rightMax) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    result += Math.max(0,  (leftMax - height[left]));
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    result += Math.max(0, (rightMax - height[right]));
                }
                right--;
            }
        }
        return result;
    }


//     暴力方法
//    public int trap(int[] height) {
//        int result = 0;
//        for (int i = 1; i < height.length - 1; i++) {
//            int leftMax = 0;
//            int rightMax = 0;
//            for (int j = 0; j <= i; j++) {
//                leftMax = Math.max(leftMax, height[j]);
//            }
//            for (int j = i; j < height.length; j++) {
//                rightMax = Math.max(rightMax, height[j]);
//            }
//            result += Math.min(leftMax, rightMax) - height[i];
//        }
//        return result;
//    }

}
