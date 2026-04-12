class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:

        for i in range(n):
            nums[i] = nums[i] + nums[i +n] * 1001

        for i in range(n-1, -1, -1):
            x = nums[i] % 1001
            y = nums[i] // 1001
            nums[2*i +1] = y
            nums[2*i] = x

        return nums


        