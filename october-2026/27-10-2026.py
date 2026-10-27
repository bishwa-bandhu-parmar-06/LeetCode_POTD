
# 3963. Create Grid With Exactly One Path



class Solution:
    def createGrid(self, m: int, n: int) -> list[str]:
        return ["." * n] + ["#" * (n - 1) + "."] * (m - 1)