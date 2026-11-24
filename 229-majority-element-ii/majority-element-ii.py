class Solution:
    def majorityElement(self, nums: list[int]) -> list[int]:
        ans = []
        can1 , can2 = 0, 1
        count1, count2 = 0, 0
        n = len(nums)

        for num in nums:
            if can1 == num: count1 += 1
            elif can2 == num: count2 += 1
            elif count1 == 0:
                can1 = num
                count1 = 1
            elif count2 == 0:
                can2 = num
                count2 = 1
            else:
                count1 -= 1
                count2 -= 1

        count1, count2 = 0, 0

        for num in nums:
            if can1 == num: count1 += 1
            if can2 == num: count2 += 1

        if count1 > n /3: ans.append(can1)
        if count2 > n /3: ans.append(can2)

        return ans

        