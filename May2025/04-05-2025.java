
// 1128. Number of Equivalent Domino Pairs



class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;

        for (int[] d : dominoes) {
            int x = Math.min(d[0], d[1]);
            int y = Math.max(d[0], d[1]);
            int key = (x << 4) | y;  // Unique hash
            count.put(key, count.getOrDefault(key, 0) + 1);
        }

        for (int c : count.values()) {
            ans += c * (c - 1) / 2;
        }

        return ans;
    }
}