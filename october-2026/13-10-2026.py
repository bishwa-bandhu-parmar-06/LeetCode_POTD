

# 3727. Maximum Alternating Sum of Squares

class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        A = sorted(a * a for a in nums)
        return sum(A) - sum(A[:len(A) // 2]) * 2
        