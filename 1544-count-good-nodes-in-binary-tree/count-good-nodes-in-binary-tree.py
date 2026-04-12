# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def dfs(node, maxSoFar):
            if not node:
                return 0

            count = 0

            if node.val >= maxSoFar:
                count = 1
                
            maxSoFar = max(node.val, maxSoFar)

            count += dfs(node.left, maxSoFar)
            count += dfs(node.right, maxSoFar)

            return count

        return dfs(root, root.val)
        