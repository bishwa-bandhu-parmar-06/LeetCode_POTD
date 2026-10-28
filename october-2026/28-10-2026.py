

# 3882. Minimum XOR Path in a Grid



class Solution:
    def minCost(self, grid: list[list[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dp = [[set() for _ in range(n)] for _ in range(m)]
        dp[0][0].add(grid[0][0])
        t = grid[0][0]
        for i in range(1, m):
            t ^= grid[i][0]
            dp[i][0].add(t)

        t = grid[0][0]
        for j in range(1, n):
            t ^= grid[0][j]
            dp[0][j].add(t)

        for i in range(1, m):
            for j in range(1, n):
                for k in dp[i-1][j]:
                    dp[i][j].add(grid[i][j] ^ k)
                for k in dp[i][j-1]:
                    dp[i][j].add(grid[i][j] ^ k)

        return min(dp[-1][-1])