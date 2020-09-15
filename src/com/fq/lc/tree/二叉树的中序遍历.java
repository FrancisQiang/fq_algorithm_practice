package com.fq.lc.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author muXue
 * @date 2020/9/15 16:55
 */
public class 二叉树的中序遍历 {

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }

    // 非递归实现
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                curNode = pop.right;
            }
        }
        return result;
    }

}
