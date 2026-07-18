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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private int dfs(TreeNode node, int l, int h){
        if(node == null) return 0;

        int left = dfs(node.left, l, h);
        int right = dfs(node.right, l, h);

        int curr = 0;
        if(node.val >= l && node.val <= h) curr = node.val;

        return left + right + curr;
    }
}