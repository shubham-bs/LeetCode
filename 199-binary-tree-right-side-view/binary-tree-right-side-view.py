# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        q = deque()
        q.append(root)
        ans = []

        while q:
            level = []

            for i in range(len(q)):
                front = q.popleft()
                level.append(front.val)

                if front.left: q.append(front.left)
                if front.right: q.append(front.right)

            ans.append(level[-1])

        return ans


        