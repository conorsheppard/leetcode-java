package com.leetcode.path_sum_112;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PathSumTest {

    // Helper to construct a TreeNode
    private TreeNode tree(int val, TreeNode left, TreeNode right) {
        TreeNode node = new TreeNode(val);
        node.left = left;
        node.right = right;
        return node;
    }

    @Test
    void testNullRoot() {
        assertFalse(new PathSum().hasPathSum(null, 0));
    }

    @Test
    void testSingleNodeTrue() {
        TreeNode root = new TreeNode(5);
        assertTrue(new PathSum().hasPathSum(root, 5));
    }

    @Test
    void testSingleNodeFalse() {
        TreeNode root = new TreeNode(1);
        assertFalse(new PathSum().hasPathSum(root, 2));
    }

    @Test
    void testTwoLevelTreeTrue() {
        TreeNode root = tree(1, new TreeNode(2), new TreeNode(3));
        assertTrue(new PathSum().hasPathSum(root, 3)); // 1 -> 2
    }

    @Test
    void testTwoLevelTreeFalse() {
        TreeNode root = tree(1, new TreeNode(2), new TreeNode(3));
        assertFalse(new PathSum().hasPathSum(root, 5)); // No path adds to 5
    }

    @Test
    void testMultiplePathsOnlyOneValid() {
        TreeNode root = tree(5,
                tree(4,
                        tree(11, new TreeNode(7), new TreeNode(2)),
                        null),
                tree(8,
                        null,
                        tree(4, null, new TreeNode(1)))
        );
        assertTrue(new PathSum().hasPathSum(root, 22)); // Path: 5->4->11->2
    }

    @Test
    void testNegativeValues() {
        TreeNode root = tree(-2, null, tree(-3, null, null));
        assertTrue(new PathSum().hasPathSum(root, -5)); // -2 -> -3
    }

    @Test
    void testNoLeafMatch() {
        TreeNode root = tree(1, new TreeNode(2), null);
        assertFalse(new PathSum().hasPathSum(root, 1)); // Ends at non-leaf
    }

    @Test
    void testTarget14() {
        TreeNode right = tree(5, new TreeNode(4), new TreeNode(6));
        TreeNode root = tree(3, new TreeNode(1), right);
        assertTrue(new PathSum().hasPathSum(root, 14)); // Path: 3 -> 5 -> 6
    }
}
