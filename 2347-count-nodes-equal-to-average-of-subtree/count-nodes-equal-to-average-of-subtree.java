/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int matchingNodesCount = 0;

    public int averageOfSubtree(TreeNode root) {
        matchingNodesCount = 0; 
        calculateSumAndCount(root);
        return matchingNodesCount;
    }

    private int[] calculateSumAndCount(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = calculateSumAndCount(node.left);
        int[] right = calculateSumAndCount(node.right);

        int currentSum = node.val + left[0] + right[0];
        int currentCount = 1 + left[1] + right[1];

        if (currentSum / currentCount == node.val) {
            matchingNodesCount++;
        }

        return new int[]{currentSum, currentCount};
    }
}
