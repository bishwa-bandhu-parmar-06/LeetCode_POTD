

# 1732. Find the Highest Altitude

class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        currentaltitude = 0
        maxaltitude = 0
        for i in gain:
            currentaltitude += i
            maxaltitude = max(maxaltitude, currentaltitude)
        return maxaltitude