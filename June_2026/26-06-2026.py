

# 
# 3739. Count Subarrays With Majority Element II

from collections import defaultdict
class Solution:
    def countMajoritySubarrays(self, nums: List[int], target: int) -> int:
        sums = 0
        mp = defaultdict(int)
        ans = 0
        mp[0] = 1
        prevans = 0
        for i in range(len(nums)):
            prev = sums
            if target == nums[i]: sums += 1
            else: sums -= 1
            if prev > sums:
                prevans =  max(prevans - mp[sums], 0)
            else:
                prevans = (prevans + mp[prev])

            mp[sums] += 1
            ans += prevans

        return ans