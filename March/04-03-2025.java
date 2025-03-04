// 1780. Check if Number is a Sum of Powers of Three


class Solution {
    public boolean checkPowersOfThree(int n) {
        String base3 = Integer.toString(n, 3);
        
        return !base3.contains("2");
    }
}