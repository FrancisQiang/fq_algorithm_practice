package com.fq.lc.doublepointer;

import java.util.HashSet;
import java.util.Set;

/**给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:
 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 示例 2:
 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

 示例 3:
 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 * @author lgq
 * @date 2020/6/11
 */
public class 无重复字符的最长子串 {

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
