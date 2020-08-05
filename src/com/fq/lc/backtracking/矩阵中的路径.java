package com.fq.lc.backtracking;

/**
 * @author muXue
 * @date 2020/8/5 15:52
 */
public class 矩阵中的路径 {

    private char[][] board;

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        // 特判
        if (board.length == 0 || word.length() == 0) {
            return false;
        }
        this.board = board;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        // 如果超出范围了
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        // 如果没有被访问
        if (!visited[i][j]) {
            char c = word.charAt(index);
            if (c == board[i][j]) {
                visited[i][j] = true;
                // 上下左右
                boolean b1 = helper(i - 1, j, word, index + 1);
                boolean b2 = helper(i + 1, j, word, index + 1);
                boolean b3 = helper(i, j - 1, word, index + 1);
                boolean b4 = helper(i, j + 1, word, index + 1);
                visited[i][j] = false;
                return b1 || b2 || b3 || b4;
            } else {
                return false;
            }
        }
        return false;
    }


}
