package com.fq.lc.tree;

/**
 * @author lgq
 * @date 2020/6/10
 */
public class 二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终止条件
        // 当节点为null 或者 等于p或q的时候直接return root
        // 这点表示，如果子树返回给父节点为null 那么公共节点肯定不在该子树中
        // 如果左右两边子树返回的都不是空，那么此时该父节点就是最近祖先
        // 如果 左或者右子树有一个返回的不是空 那么就返回不是空的
        // 这种情况可以分为两种，一种是两个节点都在那里，另一种是分布在其他地方
        // 我们只需要保证 节点为null 或者等于p或q返回root 如果左右节点返回的都不是空则返回该结点
        // 如果有一个不是空则返回不是空的那个节点
        if (root == null || root == p || root == q) {
            return root;
        }
        // 如果终止条件不满足 那么看左右节点返回情况
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左右节点返回的都不是空 那么这个结点就是最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 如果这个结点不是公共祖先 那么向上返回对应的不为空的node 也可能都是为空
        return left == null ? right : left;
    }

}