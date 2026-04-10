# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        depth = 0
        q = deque()
        q.append(root)

        while q:
            for i in range(len(q)):
                front = q.popleft()
                if front.left: q.append(front.left)
                if front.right: q.append(front.right)

            depth += 1

        return depth

        