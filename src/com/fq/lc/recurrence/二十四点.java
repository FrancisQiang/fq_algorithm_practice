package com.fq.lc.recurrence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lgq
 * @date 2020/8/13
 */
public class 二十四点 {


    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double )num);
        }
        return helper(list);
    }

    private boolean helper(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 1e-6;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                List<Double> newList = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        newList.add((double)list.get(k));
                    }
                }
                double a = list.get(i);
                double b = list.get(j);
                newList.add(a + b);
                if (helper(newList)) {
                    return true;
                }
                newList.remove(newList.size() - 1);
                newList.add(a - b);
                if (helper(newList)) {
                    return true;
                }
                newList.add(a * b);
                newList.remove(newList.size() - 1);
                if (helper(newList)) {
                    return true;
                }
                newList.remove(newList.size() - 1);
                if (b != 0) {
                    newList.add(a / b);
                    if (helper(newList)) {
                        return true;
                    }
                    newList.remove(newList.size() - 1);
                }
            }
        }
        return false;
    }


}
