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
    private TreeNode dummy = new TreeNode(-1);
    private TreeNode curr = dummy;
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return dummy.right;
    }

    private void inOrder(TreeNode node){
        if(node == null) return;

        inOrder(node.left);
        
        node.left = null;
        curr.right = node;
        curr = node;

        inOrder(node.right); 
    }
}