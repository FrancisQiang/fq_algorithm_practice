package com.fq.lc.string;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * @author lgq
 * @date 2020/8/22
 */
public class 字符串解码 {

    // 辅助栈
//    public String decodeString(String s) {
//        StringBuilder answer = new StringBuilder();
//        int multiply = 0;
//        Stack<Integer> numberStack = new Stack<>();
//        Stack<StringBuilder> stringStack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (Character.isDigit(c)) {
//                multiply = multiply * 10 + (c - '0');
//            } else if (Character.isLetter(c)) {
//                answer.append(c);
//            } else if (c == '[') {
//                numberStack.push(multiply);
//                stringStack.push(new StringBuilder(answer));
//                multiply = 0;
//                answer = new StringBuilder();
//            } else {
//                // 此时为 ']'
//                StringBuilder temp = stringStack.pop();
//                int tempMultiply = numberStack.pop();
//                for (int j = 0; j < tempMultiply; j++) {
//                    temp.append(answer);
//                }
//                answer = new StringBuilder(temp);
//            }
//        }
//        return answer.toString();
//    }

    // 递归


    int index = 0; // 全局变量记录遍历到的位置
    public String decodeString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(; index < s.length(); index++) {
            if(Character.isDigit(s.charAt(index))) {
                num = num * 10 + s.charAt(index) - '0'; // 记录个数
            } else if (s.charAt(index) == '[') {
                index++;
                String str = decodeString(s); // 遇到左括号，递归计算这个括号内的解码字符串
                for(int i = 0; i < num; i++) { // 然后添加
                    sb.append(str);
                }
                num = 0; // 置0
            } else if (s.charAt(index) == ']') {
                return sb.toString(); // 遇到右括号结束递归返回给上一层
            } else {
                sb.append(s.charAt(index));// 是字符就添加
            }
        }
        return sb.toString();
    }

}
