package com.fq.lc.dp;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例：
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @author lgq
 * @date 2020/6/7
 */
public class 最小路径和 {

    private int m;
    private int n;
    private boolean inArea(int i, int j) {
        return !(i < 0 || i >= m || j < 0 || j >= n);
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        this.m = grid.length;
        this.n = grid[0].length;
        int[][] dp = new int[m][n];
        // 初始化dp最后的
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (inArea(i + 1, j)) {
                    if (inArea(i, j + 1)) {
                        // 此时则可以使用方程
                        dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                    } else {
                        // 此时说明右边越界 则只能是下边
                        dp[i][j] = grid[i][j] + dp[i + 1][j];
                    }
                } else {
                    // 此时下边越界，则首先判断是否右边没越界
                    if (inArea(i, j + 1)) {
                        dp[i][j] = grid[i][j] + dp[i][j + 1];
                    } else {
                        // 此时其实它就是右下角
                        dp[i][j] = grid[i][j];
                    }
                }
            }
        }
        return dp[0][0];
    }

}
