

# 1979. Find Greatest Common Divisor of Array
# Solved

class Solution:
    def findGCD(self, nums: List[int]) -> int:
        a = min(nums)
        b = max(nums)

        while b:
            a, b = b, a % b

        return a