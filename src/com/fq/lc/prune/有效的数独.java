package com.fq.lc.prune;

import java.util.*;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * @author lgq
 * @date 2020/8/8
 */
public class 有效的数独 {

    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> columnSet = new ArrayList<>();
        List<Set<Character>> rowSet = new ArrayList<>();
        List<Set<Character>> boxSet = new ArrayList<>();
        // 判断每行中是否有重复元素
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (set.contains(board[j][i])) {
                    return false;
                } else {
                    set.add(board[j][i]);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            int jstart = i / 3;
            int kstart = i % 3;
            Set<Character> set = new HashSet<>();
            for (int j = jstart * 3; j < jstart * 3 + 3; j++) {
                for (int k = kstart * 3; k < kstart * 3 + 3; k++) {
                    if (board[j][k] == '.') {
                        continue;
                    }
                    if (set.contains(board[j][k])) {
                        return false;
                    } else {
                        set.add(board[j][k]);
                    }
                }
            }
        }
        return true;
    }

}
