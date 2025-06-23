package com.leetcode.path_sum_112;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        return hasPathSum(root, targetSum, root.val, false);
    }

    private boolean hasPathSum(TreeNode node, int targetSum, int acc, boolean hasPathSum) {
        if (node.left == null && node.right == null && acc == targetSum) {
            hasPathSum = true;
            return hasPathSum;
        }

        if (node.left != null) {
            hasPathSum = hasPathSum(node.left, targetSum, acc + node.left.val, hasPathSum);
        }
        if (node.right != null) {
            hasPathSum = hasPathSum(node.right, targetSum, acc + node.right.val, hasPathSum);
        }

        return hasPathSum;
    }
}
