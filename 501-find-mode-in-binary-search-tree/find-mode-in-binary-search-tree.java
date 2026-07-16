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

    List<Integer> ans = new ArrayList<>();
    Integer prev = null;
    int count = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        inOrder(root);

        int n = ans.size();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = ans.get(i);
        }

        return res;
    }

    private void inOrder(TreeNode node){
        if(node == null) return;

        inOrder(node.left);
        
        process(node);

        inOrder(node.right);
    }

    private void process(TreeNode node){
        if(prev == null || prev != node.val) count = 1;
        else count++;

        if(count > maxCount){
            maxCount = count;
            ans.clear();
            ans.add(node.val);
        }else if(count == maxCount){
            ans.add(node.val);
        }

        prev = node.val;
    }
}