
# 1288. Remove Covered Intervals

class Solution:
    def removeCoveredIntervals(self, invs: List[List[int]]) -> int:
        rmax = res = 0
        for l, r in sorted(invs, key=lambda p: (p[0], -p[1])):
            if rmax < r:
                rmax = r
                res += 1
        return res