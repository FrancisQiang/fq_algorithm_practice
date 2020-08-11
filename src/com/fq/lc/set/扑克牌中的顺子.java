package com.fq.lc.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
 * A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 * @author muXue
 * @date 2020/8/11 16:11
 */
public class 扑克牌中的顺子 {

    public boolean isStraight(int[] nums) {
        int min = 15;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        return max - min < 5;
    }

}
