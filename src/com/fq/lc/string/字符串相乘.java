package com.fq.lc.string;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，
 * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * @author muXue
 * @date 2020/8/13 15:39
 */
public class 字符串相乘 {

    public static void main(String[] args) {
        字符串相乘 test = new 字符串相乘();
        test.multiply("123", "456");
    }

    public String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (int i = length2 - 1; i >= 0; i--) {
            StringBuilder tempResult = new StringBuilder();
            int carry = 0;
            for (int j = length1 - 1; j >= 0; j--) {
                int number2 = num2.charAt(i) - '0';
                int number1 = num1.charAt(j) - '0';
                int multiplyResult = number2 * number1 + carry;
                carry = multiplyResult / 10;
                tempResult.append(multiplyResult % 10);
            }
            if (carry > 0) {
                tempResult.append(carry);
            }
            StringBuilder reverse = tempResult.reverse();
            for (int k = 0; k < length2 - 1 - i; k++) {
                reverse.append(0);
            }
            result = sum(result.toString(), reverse.toString());
            System.out.println(result);
        }
        return result.toString();
    }

    private StringBuilder sum(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int i = length1 - 1;
        int j = length2 - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int number1;
            int number2;
            if (i < 0) {
                number1 = 0;
            } else {
                number1 = num1.charAt(i) - '0';
            }
            if (j < 0) {
                number2 = 0;
            } else {
                number2 = num2.charAt(j) - '0';
            }
            result.append((number1 + number2 + carry) % 10);
            carry = (number1 + number2 + carry) / 10;
            i--;
            j--;
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse();
    }



}
