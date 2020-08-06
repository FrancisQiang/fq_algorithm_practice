package com.fq.lc.backtracking;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * @author muXue
 * @date 2020/8/5 16:52
 */
public class 机器人的运动范围 {

    private int m;
    private int n;
    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        this.m = m;
        this.n = n;
        this.visited = new boolean[m][n];
        return helper(0, 0, k, 0);
    }

    private int helper(int i, int j, int k, int count) {
        if (i > m - 1 || i < 0 || j > n - 1 || j < 0) {
            return 0;
        }
        if (calculate(i) + calculate(j) > k) {
            return 0;
        }
        // 此时是符合条件 则占位
        if (!visited[i][j]) {
            visited[i][j] = true;
            // 上下左右
            return helper(i + 1, j, k, count + 1)
                    + helper(i - 1, j, k, count + 1)
                    + helper(i, j + 1, k, count + 1)
                    + helper(i, j - 1, k, count + 1)
                    + 1;
        }
        return 0;
    }

    private int calculate(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
