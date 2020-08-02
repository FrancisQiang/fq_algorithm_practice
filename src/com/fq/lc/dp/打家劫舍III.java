package com.fq.lc.dp;

import com.fq.lc.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * @author muXue
 * @date 2020/8/2 14:31
 */
public class 打家劫舍III {



    public class Solution {

        // 树的后序遍历
        public int rob(TreeNode root) {
            int[] res = dfs(root);
            return Math.max(res[0], res[1]);
        }

        private int[] dfs(TreeNode node) {
            if (node == null) {
                return new int[]{0, 0};
            }
            // 分类讨论的标准是：当前结点偷或者不偷
            // 由于需要后序遍历，所以先计算左右子结点，然后计算当前结点的状态值
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);

            // dp[0]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点不偷
            // dp[1]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点偷
            int[] dp = new int[2];
            // 左右节点的情况返回给父节点
            // 如果当前节点不偷 那么取左右孩子所有情况的最大值
            dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            // 如果当前节点偷 那么左右孩子都不能偷
            dp[1] = node.val + left[0] + right[0];
            return dp;
        }
    }


    /**
     * [2,1,3,null,4]
     * 并不是简单的隔代，比如父亲层级的右节点和父亲层左节点的孩子是不相连的。。。
     * @param root 根
     * @return 最大value
     */
    public static int robFailure(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 首先层序遍历 计算每一层总数
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 存放每一层总数
        List<Integer> sumList = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 循环计算一层的总数
            int sum = 0;
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            // 加入 sumList
            sumList.add(sum);
        }
        StringBuilder stringBuilder = new StringBuilder();
        sumList.forEach(element -> stringBuilder.append(",").append(element));
        System.out.println(stringBuilder);
        // 现在归结为打家劫舍最初的题目了 即相邻的不能偷
        if (sumList.size() == 1) {
            return sumList.get(0);
        }
        int[] dp = new int[sumList.size()];
        dp[0] = sumList.get(0);
        dp[1] = Math.max(sumList.get(0), sumList.get(1));
        for (int i = 2; i < sumList.size(); i++) {
            dp[i] = Math.max(dp[i - 2] + sumList.get(i), dp[i - 1]);
        }
        return dp[sumList.size() - 1];
    }



}
