package com.fq.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lgq
 * @date 2020/6/6
 */
public class BinarySearchTree {

    private TreeNode root;
    private int size;

    public void add(int val) {
        root = add(root, val);
    }

    private TreeNode add(TreeNode node, int val) {
        if (node == null) {
            size++;
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = add(node, val);
        } else if (val > node.val) {
            node.right = add(node, val);
        }
        return node;
    }

    private void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    private void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.val);
    }

    public void levelOrder() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            if (first != null) {
                System.out.println(first.val);
                queue.offer(first.left);
                queue.offer(first.right);
            }
        }
    }

    public TreeNode minimum() {
        return minimum(root);
    }

    private TreeNode minimum(TreeNode node) {
        if (size == 0) {
            throw new IllegalArgumentException("The BinarySearchTree is empty");
        }
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public TreeNode maximum() {
        return maximum(root);
    }

    private TreeNode maximum(TreeNode node) {
        if (size == 0) {
            throw new IllegalArgumentException("The BinarySearchTree is empty");
        }
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public void remove(int val) {
        root = remove(root, val);
    }

    private TreeNode remove(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (val < node.val) {
            node.left = remove(node.left, val);
            return node;
        } else if (val > node.val) {
            node.right = remove(node.right, val);
            return node;
        } else {
            // 如果相等节点左子树为空
            if (node.left == null) {
                TreeNode rightChild = node.right;
                node.right = null;
                size--;
                return rightChild;
            } else if (node.right == null) {
                TreeNode leftChild = node.left;
                node.left = null;
                size--;
                return leftChild;
            } else {
                // 否则获取该结点右孩子最小结点
                TreeNode successor = minimum(node.right);
                // 将当前节点左孩子赋值给右孩子最小结点的左孩子
                successor.left = node.left;
                // 当前节点的右孩子(删去刚刚的最小结点)赋值给右孩子最小结点的右子树
                // 这里没有size-- 因为在removeMin中有该操作
                successor.right = removeMin(node.right);
                // 回收
                node.left = node.right = null;
                return successor;
            }
        }
    }

    private TreeNode removeMin(TreeNode node) {
        // 当前节点为最小结点 直接移除
        if (node.left == null) {
            size--;
            return null;
        }
        node.left = removeMin(node.left);
        return node;
    }

}
