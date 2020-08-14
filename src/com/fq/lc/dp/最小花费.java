package com.fq.lc.dp;

/**
 * @author muXue
 * @date 2020/8/13 17:31
 */
public class 最小花费 {


    public static int minSpend(int price) {
        boolean[] dp = new boolean[price + 1];
        dp[0] = true;
        if (price >= 11) {
            dp[11] = true;
        }
        if (price >= 30) {
            dp[30] = true;
        }
        if (price >= 40) {
            dp[40] = true;
        }
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            boolean b3 = false;
            boolean b11 = false;
            boolean b5 = false;
            if (i >= 11) {
                b3 = dp[i - 11];
            }
            if (i >= 30) {
                b5 = dp[i - 30];
            }
            if (i >= 40) {
                b11 = dp[i - 40];
            }
            dp[i] = b3 || b5 || b11;
            if (dp[i]) {
                max = i;
            }
        }
        return price - max;
    }

    public static void main(String[] args) {
        System.out.println(minSpend(62));
    }

}
