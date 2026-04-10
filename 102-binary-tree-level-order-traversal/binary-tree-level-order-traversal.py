# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
            
        q = deque()
        ans = []
        q.append(root)

        while len(q) > 0:
            level = []

            for i in range(len(q)):
                front = q.popleft()
                if front.left:
                    q.append(front.left)
                if front.right:
                    q.append(front.right)
                level.append(front.val)

            ans.append(level)

        return ans

        