

# 1614. Maximum Nesting Depth of the Parentheses


class Solution:
    def maxDepth(self, s: str) -> int:
        return max(accumulate((c=='(')-(c==')') for c in s))  