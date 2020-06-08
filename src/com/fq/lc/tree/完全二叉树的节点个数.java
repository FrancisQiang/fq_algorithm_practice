package com.fq.lc.tree;

/**
 * @author lgq
 * @date 2020/6/8
 */
public class 完全二叉树的节点个数 {

    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }

}
