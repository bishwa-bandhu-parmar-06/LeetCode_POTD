

# 3731. Find Missing Elements

class Solution:
    def findMissingElements(self, nums):
        m = float('inf')
        ma = float('-inf')
        for x in nums:
            if x < m:
                m = x
            if x > ma:
                ma = x
        s = set()
        for b in nums:
            s.add(b)
        ans = []
        for a in range(m, ma + 1):
            if a not in s:
                ans.append(a)
        return ans