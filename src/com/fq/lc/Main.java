package com.fq.lc;

import java.io.IOException;
import java.util.*;

/**
 * @author lgq
 * @date 2020/8/25
 */
public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 三角形的层数
        int n = scan.nextInt();
        int[][] dp = new int[n + 1][2 * n + 1];
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            int[] intArr = new int[(i + 1) * 2 - 1];
            int index = 0;
            while(index < intArr.length && scan.hasNextInt()) {
                intArr[index] = scan.nextInt();
                index++;
            }
            for (int element : intArr) {
                list.add(element);
            }
            triangle.add(list);
        }
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // dp记录着 该点到最后一行的最大距离
                dp[i][j] = triangle.get(i).get(j) + Math.max(Math.max(dp[i + 1][j], dp[i + 1][j + 1]), dp[i + 1][j + 2]);
            }
        }
        System.out.println(dp[0][0]);
    }
}