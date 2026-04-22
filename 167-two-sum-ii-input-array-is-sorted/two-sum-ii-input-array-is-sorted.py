class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        dict1 = {}

        for i, num in enumerate(numbers):
            if target - num in dict1:
                return (dict1[target - num] + 1, i +1)
            else:
                dict1[num] = i