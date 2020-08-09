package com.fq.lc.linkedlist;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * @author lgq
 * @date 2020/8/8
 */
public class 排序链表 {

    public ListNode sortList(ListNode head) {
        // 快慢指针找到中间节点和尾结点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 中间往右
        ListNode r = sortList(slow.next);
        // 断开链表
        slow.next = null;
        // 起点往右
        ListNode l = sortList(head);
        return merge(l, r);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null || right == null) {
            return left == null ? right : left;
        }
        ListNode leftCur = left;
        ListNode rightCur = right;
        ListNode preNode = new ListNode(-1);
        ListNode curNode = preNode;
        while(true) {
            if (leftCur == null) {
                curNode.next = rightCur;
                break;
            }
            if (rightCur == null) {
                curNode.next = leftCur;
                break;
            }
            if (leftCur.val <= rightCur.val) {
                curNode.next = leftCur;
                leftCur = leftCur.next;
                continue;
            } else {
                curNode.next = rightCur;
                rightCur = rightCur.next;
            }
        }
        return preNode.next;
    }

}
