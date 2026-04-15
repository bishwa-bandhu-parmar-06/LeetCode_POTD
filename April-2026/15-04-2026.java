

// 2515. Shortest Distance to Target String in a Circular Array

class Solution {
    public int closestTarget(String[] w, String t, int si) {
        int n = w.length;
        int ans = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (w[i].equals(t)) {
                found = true;
                int dist = Math.abs(i - si);
                dist = Math.min(dist, n - dist); // circular correction

                ans = Math.min(ans, dist);
            }
        }
        return found ? ans : -1;
    }
}