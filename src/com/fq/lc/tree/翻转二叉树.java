package com.fq.lc.tree;

/**
 * @author lgq
 * @date 2020/6/9
 */
public class 翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.right = left;
        root.left = right;
        return root;
    }

}
