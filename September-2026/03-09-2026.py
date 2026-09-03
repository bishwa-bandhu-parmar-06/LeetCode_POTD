
# 3876. Construct Uniform Parity Array II

class Solution:
    def uniformArray(self, nums1: list[int]) -> bool:
        # Case 1: All numbers are already even
        if all(x % 2 == 0 for x in nums1):
            return True

        # Case 2: Make everything odd
        # The smallest number must be odd.
        return min(nums1) % 2 == 1