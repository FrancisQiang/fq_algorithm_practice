package com.fq.lc.tree;

/**
 * @author lgq
 * @date 2020/9/7
 */
public class 二分搜索树与双向链表 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node pre = null, head = null;

    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        helper(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void helper(Node node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        if (pre == null) {
            head = node;
            pre = node;
        } else {
            pre.right = node;
            node.left = pre;
            pre = node;
        }
        helper(node.right);
    }

}
