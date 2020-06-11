package com.fq.lc.linkedlist;

import java.util.HashSet;

/**
 * @author lgq
 * @date 2020/6/11
 */
public class 环形链表 {

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(cur != null) {
            if(!set.contains(cur)) {
                set.add(cur);
            } else {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

}
