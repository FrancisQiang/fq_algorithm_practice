package com.fq.lc.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * @author muXue
 * @date 2020/8/4 19:01
 */
public class 从尾到头打印链表 {

    // 递归实现

    private List<Integer> result = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        helper(head, result);
        int[] arr = new int[result.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    private void helper(ListNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        helper(node.next, result);
        result.add(node.val);
    }


}
