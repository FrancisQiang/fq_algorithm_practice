package com.fq.lc.calculate;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：6
 * @author lgq
 * @date 2020/8/2
 */
public class 一到n整数中1出现的次数 {

    private int times = 0;

    // 别整数学 就循环递归
    public int countDigitOne(int n) {
        for (int i = 1; i <= n; i++) {
            calculate(i);
        }
        return times;
    }

    private void calculate(int n) {
        while (n > 0) {
            if (n % 10 == 1) {
                times++;
            }
            n /= 10;
        }
    }

}
