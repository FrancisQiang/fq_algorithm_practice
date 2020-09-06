package com.fq.lc.map;

import java.util.HashSet;
import java.util.Set;

/**
 * @author muXue
 * @date 2020/8/18 16:22
 */
public class 无重复字符的最长字串 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int i = 0, j = 0;
        while(true) {
            if (j < s.length()) {
                if (set.contains(s.charAt(j))) {
                    maxLength = Math.max(maxLength, j - i);
                    set.remove(s.charAt(i));
                    i++;
                } else {
                    set.add(s.charAt(j));
                    j++;
                }
            } else {
                if (i < j) {
                    if (set.contains(s.charAt(j - 1))) {
                        maxLength = Math.max(maxLength, j - i);
                        set.remove(s.charAt(i));
                        i++;
                    }
                } else if (i == j) {
                    break;
                }
            }
        }
        return maxLength;
    }



}
