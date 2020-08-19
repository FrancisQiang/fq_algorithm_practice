package com.fq.lc.string;

/**
 * @author muXue
 * @date 2020/8/19 11:34
 */
public class 回文子串 {


    int count = 0;

    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return count;
        }
        for (int i = 0; i < s.length(); i++) {
            count(i, i, s);
            count(i, i + 1, s);
        }
        return count;
    }

    private void count(int start, int end, String s) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
    }

}
