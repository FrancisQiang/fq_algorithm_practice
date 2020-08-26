package com.fq.lc;

import java.util.*;

/**
 * @author lgq
 * @date 2020/8/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 最大车速
        int s = sc.nextInt();
        double spendPerseconds = (s * 1000) / (double) 3600;
        // 红绿灯个数
        int n = sc.nextInt();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int distance = sc.nextInt();
            int time = sc.nextInt();
            double maxSpeed = 0;
            while (true) {
                maxSpeed = distance / (double) time;
                if (maxSpeed > spendPerseconds) {
                    time += time;
                    continue;
                } else {
                    break;
                }
            }
            max = Math.max(max, (int) (maxSpeed * 3600) / 1000);
        }
        if (max < s) {
            System.out.println(max);
        } else {
            System.out.println(s);
        }
    }
}