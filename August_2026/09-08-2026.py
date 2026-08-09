
# 1140. Stone Game II



class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        l = [0]*(len(piles) + 1)
        for i in range(n-1,-1,-1):
            l[i] = l[i+1] + piles[i]
        @lru_cache(maxsize = None)
        def f(i,m):
            if i >= n:
                return 0
            if 2*m >= n - i:
                return l[i]
            ans = 0
            for j in range(1,2*m+1):
                ans = max(ans,l[i] - f(i+j,max(m,j)))
            return ans
        return f(0,1)