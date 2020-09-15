package com.fq.lc.string;

/**
 * @author muXue
 * @date 2020/9/15 12:51
 */
public class 最后一个单词的长度 {

    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length != 0) {
                return length;
            }
        }
        return length;
    }

}
