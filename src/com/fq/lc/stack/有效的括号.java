package com.fq.lc.stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @author lgq
 * @date 2020/6/11
 */
public class 有效的括号 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (c == ')' && pop == '(') {
                    continue;
                } else if (c == '}' && pop == '{') {
                    continue;
                } else if (c == ']' && pop == '[') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
