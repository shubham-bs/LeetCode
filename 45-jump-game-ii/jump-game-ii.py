class Solution:
    def jump(self, nums: list[int]) -> int:
        jumps = 0
        currEnd = 0
        maxReach = 0

        for i in range(len(nums) -1):
            maxReach = max(maxReach, i + nums[i])

            if i == currEnd:
                currEnd = maxReach
                jumps += 1

        return jumps
        