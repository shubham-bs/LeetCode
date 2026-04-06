class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        currSum = 0
        prefix = {0:1}

        for num in nums:
            currSum += num
            need = currSum - k

            if need in prefix:
                count += prefix[need]

            prefix[currSum] = prefix.get(currSum, 0) + 1

        return count