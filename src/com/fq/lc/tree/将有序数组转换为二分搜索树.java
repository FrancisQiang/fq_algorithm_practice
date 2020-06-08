package com.fq.lc.tree;

/**
 * @author lgq
 * @date 2020/6/8
 */
public class 将有序数组转换为二分搜索树 {

    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    private TreeNode helper(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (r - l) / 2 + l;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(l, mid - 1);
        node.right = helper(mid + 1, r);
        return node;
    }


}
