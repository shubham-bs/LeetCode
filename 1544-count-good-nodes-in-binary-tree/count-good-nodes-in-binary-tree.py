# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        count = 0

        def dfs(node, maxSoFar = float('-inf')):
            if not node:
                return 

            nonlocal count 
            if node.val >= maxSoFar:
                count += 1
                maxSoFar = node.val

            dfs(node.left, maxSoFar)
            dfs(node.right, maxSoFar)

        dfs(root)
        return count

            

            

            

            