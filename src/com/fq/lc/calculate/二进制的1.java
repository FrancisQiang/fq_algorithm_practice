package com.fq.lc.calculate;

/**
 * @author muXue
 * @date 2020/8/7 17:49
 */
public class 二进制的1 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

}
