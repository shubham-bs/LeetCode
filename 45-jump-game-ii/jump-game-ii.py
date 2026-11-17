class Solution:
    def jump(self, nums: list[int]) -> int:
        dp = [-1] * len(nums)
        return self.helper(nums, 0, dp)

    def helper(
        self, 
        nums: list[int],  
        idx: int,
        dp: list[int]
    )-> int:

        if idx == len(nums) -1: return 0
        if dp[idx] != -1: return dp[idx]

        jumps = float('inf')

        for i in range(idx +1, idx + nums[idx] +1):
            if i < len(nums):
                jumps = min(
                    jumps,
                    self.helper(nums, i, dp) +1
                )
            
        dp[idx] = jumps
        return jumps 
            

        