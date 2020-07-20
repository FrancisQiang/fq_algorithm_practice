package com.fq.lc.bfs;

/**
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1

 * @author muXue
 * @date 2020/7/20 10:26
 */
public class 岛屿数量 {

    char[][] grid;
    int maxX;
    int maxY;


    public int numIslands(char[][] grid) {
        this.grid = grid;
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        this.maxX = grid.length;
        this.maxY = grid[0].length;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果为1 则深度优先遍历将周围都置为0 并且结果++
                if (this.grid[i][j] == '1') {
                    result++;
                    dfs(i, j);
                }
            }
        }
        return result;

    }

    private void dfs(int x, int y) {
        if (!inArea(x, y) || this.grid[x][y] == '0') {
            return;
        }
        this.grid[x][y] = '0';
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x + 1, y);
        dfs(x, y - 1);
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.maxX && y >= 0 && y < maxY;
    }


}
