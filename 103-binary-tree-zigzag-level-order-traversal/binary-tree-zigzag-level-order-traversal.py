# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        q = deque()
        ans = []
        q.append(root)

        while q:
            level = []
            for i in range(len(q)):
                front = q.popleft()
                level.append(front.val)

                if front.left: q.append(front.left)
                if front.right: q.append(front.right)
                
            if len(ans) % 2 != 0:
                level = level[::-1]

            ans.append(level)
            
        return ans

            

        