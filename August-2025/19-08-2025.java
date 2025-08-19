
// 2348. Number of Zero-Filled Subarrays



class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long counter = 0, total = 0;
        for (int num : nums) {
            if (num == 0) {
                counter++;
                total += counter;
            } else {
                counter = 0;
            }
        }
        return total;
    }
}