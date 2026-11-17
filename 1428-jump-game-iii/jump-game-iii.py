class Solution:
    def canReach(self, arr: list[int], start: int) -> bool:
        n = len(arr)
        vis = [False] * n
        stack = deque()

        stack.append(start)

        while stack:
            idx = stack.pop()

            if arr[idx] == 0: return True
            if vis[idx]: continue

            vis[idx] = True

            idx1 = idx - arr[idx]
            idx2 = idx + arr[idx]

            if idx1 >= 0 and not vis[idx1]: stack.append(idx1)
            if idx2 < n and not vis[idx2]: stack.append(idx2)

        return False
        