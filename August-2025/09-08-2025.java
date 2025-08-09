// 231. Power of Two




class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        long pro = 1;
        while (pro < n) {
            pro *= 2;
        }

        return pro == n;
    }
}