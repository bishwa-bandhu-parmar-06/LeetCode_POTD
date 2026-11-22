

# 2124. Check if All A's Appears Before All B's




class Solution:
    def checkString(self, s: str) -> bool:
        s1 = "".join(sorted(s))
        return s1 == s