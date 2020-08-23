package com.fq.lc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * @author lgq
 * @date 2020/8/23
 */
public class 和为某一值的路径 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, new ArrayList<>(), sum);
        return result;
    }

    private void helper(TreeNode root, List<Integer> list, int rest) {
        if (root == null) {
            return;
        }
        if (root.val == rest && root.left == null && root.right == null) {
            list.add(root.val);
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(root.val);
        helper(root.left, new ArrayList<>(list), rest - root.val);
        helper(root.right, new ArrayList<>(list), rest - root.val);
    }


}
