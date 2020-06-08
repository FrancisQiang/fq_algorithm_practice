package com.fq.lc.tree;

/**
 * @author lgq
 * @date 2020/6/8
 */
public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(depth(root.left) - depth(root.right)) < 2;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

}
