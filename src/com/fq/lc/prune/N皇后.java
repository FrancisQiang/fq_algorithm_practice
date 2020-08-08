package com.fq.lc.prune;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 * @date 2020/8/8
 */
public class N皇后 {

    private List<List<String>> result = new ArrayList<>();
    private boolean[] pie;
    private boolean[] na;
    private boolean[] columnVisited;
    private boolean[][] queueMap;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.queueMap = new boolean[n][n];
        this.na = new boolean[2 * n - 1];
        this.pie = new boolean[2 * n - 1];
        this.columnVisited = new boolean[n];
        dfs(0);
        return result;
    }

    private void dfs(int level) {
        // 如果此时已经溢出 那么可以通过queueMap计算结果了
        if (level >= n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    stringBuilder.append(queueMap[i][j] ? "Q" : ".");
                }
                list.add(stringBuilder.toString());
            }
            result.add(list);
        }
        for (int j = 0; j < queueMap.length; j++) {
            // 如果都符合则放置Q 即设置queueMap指定位置为true
            if (!columnVisited[j] && !na[(j - level) + n - 1] && !pie[level + j]) {
                queueMap[level][j] = true;
                columnVisited[j] = true;
                pie[level + j] = true;
                na[(j - level) + n - 1] = true;
                dfs(level + 1);
                // 此时进行回溯
                queueMap[level][j] = false;
                columnVisited[j] = false;
                pie[level + j] = false;
                na[(j - level) + n - 1] = false;
            }
        }
    }

}
