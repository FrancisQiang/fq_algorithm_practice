package com.fq.lc.linkedlist;

/**
 * @author lgq
 * @date 2020/8/7
 */
public class 两个链表的第一个公共节点 {

    // 双指针 快慢指针 总会相遇
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA != null) {
                nodeA = nodeA.next;
            } else {
                nodeA = headB;
            }
            if (nodeB != null) {
                nodeB = nodeB.next;
            } else {
                nodeB = headA;
            }
        }
        return nodeA;
    }

}
