package com.fq.lc.math;

/**
 * @author muXue
 * @date 2020/8/14 14:29
 */
public class 翻转整数 {

    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        // 防止溢出
        return (int)n == n ? (int)n : 0;
    }

}
