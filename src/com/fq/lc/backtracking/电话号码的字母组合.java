package com.fq.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例：输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @author lgq
 * @date 2020/6/7
 */
public class 电话号码的字母组合 {

    /**
     * 首先填充数字和字符串的对应关系,这里使用数组直接表示
     */
    private String[] mapping = new String[]{
      "",
      "",
      "abc",
      "def",
      "ghi",
      "jkl",
      "mno",
      "pqrs",
      "tuv",
      "wxyz"
    };

    private String digits;
    private List<String> result = new ArrayList<>();


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        this.digits = digits;
        helper(0, new StringBuilder());
        return result;
    }

    private void helper(int start, StringBuilder stringBuilder){
        if (start == digits.length() - 1) {
            result.add(new String(stringBuilder));
            return;
        }
        // 给定字符串start位置所对应的的数字
        int index = digits.charAt(start) - '0';
        for (int i = 0; i < mapping[index].length(); i++) {
            // 加入结果集
            stringBuilder.append(mapping[index].charAt(i));
            helper(start + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }



}
