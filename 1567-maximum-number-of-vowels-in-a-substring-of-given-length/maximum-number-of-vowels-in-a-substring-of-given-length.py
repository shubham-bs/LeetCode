class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        if len(s) < k:
            return 0
        vowNum = 0

        for i in range(k):
            if s[i] in 'aeiou':
                vowNum += 1

        maxVow = vowNum

        for i in range(k, len(s)):
            if s[i] in 'aeiou':
                vowNum += 1
            if s[i -k] in 'aeiou':
                vowNum -= 1
            maxVow = max(maxVow, vowNum)

        return maxVow
        