package com.fq.lc.string;

/**
 * @author lgq
 * @date 2020/8/30
 */
public class 反转字符串中的单词III {

    public String reverseWords(String s) {
        String[] stringArr = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String element : stringArr) {
            StringBuilder sb = new StringBuilder(element);
            StringBuilder reverse = sb.reverse();
            stringBuilder.append(reverse).append(" ");
        }
        return stringBuilder.toString().trim();
    }

}
