package com.fq.lc.tree;

/**
 * @author muXue
 * @date 2020/9/15 16:46
 */
public class 二叉搜索树的后序遍历序列 {


    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1) {
            return true;
        }
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int l, int r) {
        // 终止条件
        if (l >= r) {
            return true;
        }
        // 找出根节点在最右边
        int root = postorder[r];
        // 后序遍历的序列所有小于根节点的都是在左子树中 不然就在右子树中
        // 根据划分子树然后递归
        int m = 0;
        while (m < r && postorder[m] < root) {
            m++;
        }
        // 判断右子树中是否都是大于当前根节点的
        for (int i = m; i < r; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }
        // 递归去寻找
        return helper(postorder, l, m - 1) && helper(postorder, m, r - 1);
    }


}
