package com.fq.lc.dp;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * @author lgq
 * @date 2020/8/1
 */
public class 编辑距离 {


    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 如果其中有一个长度为0，那么直接返回结果
        if (m * n == 0) {
            return Math.max(m, n);
        }
        int[][] dp = new int[m + 1][n + 1];
        // 边界初始化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 如果相等 那么就等于前面的
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 判断三种操作情况 取最小值
                    int insert = dp[i - 1][j];
                    int delete = dp[i][j - 1];
                    int update = dp[i - 1][j - 1];
                    int min = Math.min(insert, delete);
                    min = Math.min(min, update);
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[m][n];
    }

}
