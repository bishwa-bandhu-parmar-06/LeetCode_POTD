# 3550. Smallest Index With Digit Sum Equal to Index


class Solution:
    def smallestIndex(self, nums: List[int]) -> int:
        for i, x in enumerate(nums):
            digitSum=0
            while x>0:
                x, r=divmod(x, 10)
                digitSum+=r
            if digitSum==i: return i
        return -1     