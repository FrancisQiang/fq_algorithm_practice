package com.fq.lc.tree;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @author muXue
 * @date 2020/8/4 19:09
 */
public class 重建二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 找到根节点 前序遍历的第一个元素是根节点
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        // 寻找中序遍历中根节点位置 以此来分割左右子树
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        // 分割数组
        int[] leftPre = Arrays.copyOfRange(preorder, 1, 1 + rootIndex);
        int[] rightPre = Arrays.copyOfRange(preorder, 1 + rootIndex, preorder.length);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] rightIn = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        root.left = buildTree(leftPre, leftIn);
        root.right = buildTree(rightPre, rightIn);
        return root;
    }


}
