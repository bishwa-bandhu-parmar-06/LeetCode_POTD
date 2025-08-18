
// 679. 24 Game


class Solution {
    final double EPS = 1e-6; // For floating-point comparison

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int n : cards) nums.add((double) n);
        return dfs(nums);
    }

    private boolean dfs(List<Double> nums) {
        // Base case: single number remaining
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0) < EPS;
        }

        // Try all pairs of numbers
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue; // Must be distinct numbers

                List<Double> next = new ArrayList<>();
                // Add remaining numbers not being operated on
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                // Try all possible operations
                for (double val : compute(nums.get(i), nums.get(j))) {
                    next.add(val);
                    if (dfs(next)) return true;
                    next.remove(next.size() - 1); // Backtrack
                }
            }
        }
        return false;
    }

    // Generate all possible operation results
    private List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (Math.abs(b) > EPS) res.add(a / b); // Avoid division by zero
        if (Math.abs(a) > EPS) res.add(b / a);
        return res;
    }
}