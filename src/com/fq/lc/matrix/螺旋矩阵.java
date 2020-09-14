package com.fq.lc.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 * @date 2020/9/14
 */
public class 螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length, n = matrix[0].length;
        int up = 0, down = m - 1, left = 0, right = n - 1;
        while(true) {
            for(int i = left; i <= right; i++) {
                result.add(matrix[up][i]);

            }
            up++;
            if(up > down) {
                break;
            }
            for(int i = up; i <= down; i++) {
                result.add(matrix[i][right]);

            }
            --right;
            if(right < left) {
                break;
            }
            for(int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            --down;
            if(down < up) {
                break;
            }
            for(int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            ++left;
            if(left > right) {
                break;
            }
        }
        return result;
    }

}
