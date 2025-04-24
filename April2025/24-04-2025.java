// 2799. Count Complete Subarrays in an Array

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        // Calculate the number of distinct elements (unique numbers) in the 'nums' array.
        int k = (int) Arrays.stream(nums).distinct().count();

        // Initialize the 'res' variable to store the count of complete subarrays.
        int res = 0;

        // Initialize the 'left' pointer for the sliding window's left boundary.
        int left = 0;

        // Create a HashMap to store the frequency of each number within the current window.
        HashMap<Integer, Integer> windowCounts = new HashMap<>();

        // Get the length of the input array 'nums' and store it in 'n'.
        int n = nums.length;

        // Iterate through the 'nums' array using the 'right' pointer to define the right boundary of the sliding window.
        for (int right = 0; right < n; right++) {
            // Get the number at the current 'right' index.
            int rightNum = nums[right];

            // Update the frequency count of 'rightNum' in the 'windowCounts' HashMap.
            // If 'rightNum' is already in the map, increment its count.
            // Otherwise, add it to the map with a count of 1.
            windowCounts.put(rightNum, windowCounts.getOrDefault(rightNum, 0) + 1);

            // Check if the current window contains all 'k' distinct elements from the original array.
            while (windowCounts.size() == k) {
                // 'res += n - right;': Adds to `res` the number of complete subarrays that are possible from the current `left` until the end of the array.
                res += n - right;

                // Get the number at the current 'left' index.
                int leftNum = nums[left];

                // Get the frequency of the number at the left index
                int count = windowCounts.get(leftNum);

                // Reduce the frequency count of 'leftNum' in the 'windowCounts' HashMap.
                windowCounts.put(leftNum, count - 1);

                // If the frequency of 'leftNum' becomes 0 after decrementing,
                // remove it from the 'windowCounts' HashMap because it's no longer in the window.
                if (count - 1 == 0) {
                    windowCounts.remove(leftNum);
                }

                // Move the 'left' pointer to the right, shrinking the window from the left side.
                left++;
            }
        }

        // Return the total count of complete subarrays found.
        return res;
    }
}