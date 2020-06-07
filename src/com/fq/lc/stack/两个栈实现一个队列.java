package com.fq.lc.stack;

import java.util.Stack;

/**
 * @author lgq
 * @date 2020/6/7
 */
public class 两个栈实现一个队列 {

    Stack<Integer> masterStack = new Stack<>();
    Stack<Integer> slaveStack = new Stack<>();


    public void appendTail(int value) {
        // 直接加到master中
        masterStack.push(value);
    }

    public int deleteHead() {
        // 首先看 slave 中是否有元素 如果有直接移除
        // 否则将master出栈到slave 然后再slave出栈
        if (slaveStack.isEmpty()) {
            if (masterStack.isEmpty()) {
                return -1;
            }
            while (!masterStack.isEmpty()) {
                slaveStack.push(masterStack.pop());
            }
        }
        return slaveStack.pop();
    }

}
