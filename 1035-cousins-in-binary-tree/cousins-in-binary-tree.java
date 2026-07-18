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
     private TreeNode px, py;
     private int dx, dy;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return dx == dy && px != py;
    }

    private void dfs(TreeNode node, TreeNode parent, int depth, int x, int y){
        if(node == null) return;

        if(node.val == x){
            px = parent;
            dx = depth;
        }
        if(node.val == y){
            py = parent;
            dy = depth;
        }

        dfs(node.left, node, depth +1, x, y);
        dfs(node.right, node, depth +1, x, y);
    }
}