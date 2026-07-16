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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int left = leftHeight(root);
        int right = rightHeight(root);

        if(left == right) return (1 << left) -1;

        return countNodes(root.left) +countNodes(root.right) +1;
    }

    private int leftHeight(TreeNode node){
        if(node == null) return 0;

        int height = 0;

        while(node != null){
            height++;
            node = node.left;
        }

        return height;
    }

    private int rightHeight(TreeNode node){
        if(node == null) return 0;

        int height = 0;

        while(node != null){
            height++;
            node = node.right;
        }

        return height;
    }
}