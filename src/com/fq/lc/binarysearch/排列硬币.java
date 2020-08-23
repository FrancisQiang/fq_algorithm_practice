package com.fq.lc.binarysearch;

/**
 * @author lgq
 * @date 2020/8/22
 */
public class 排列硬币 {

    public int arrangeCoins(int n) {
        int low = 1, high = n;
        while(low <= high) {
            int mid = (high - low) / 2 + low;
            int tempResult = ((1 + mid) * mid)   / 2;
            if (tempResult < n) {
                low = mid + 1;
            } else if (tempResult > n) {
                high = mid;
            } else {
                return mid;
            }
        }
        return high;
    }


}
