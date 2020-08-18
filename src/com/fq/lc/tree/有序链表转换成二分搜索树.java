package com.fq.lc.tree;

import com.fq.lc.linkedlist.ListNode;

/**
 * @author muXue
 * @date 2020/8/18 14:55
 */
public class 有序链表转换成二分搜索树 {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        else if(head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;
        //找到链表的中点p
        while(q!=null && q.next!=null){
            pre = pre.next;
            p = pre.next;
            q = q.next.next;
        }
        //将中点左边的链表分开
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }



}
