// 2616. Minimize the Maximum Difference of Pairs

class Solution {
    public int minimizeMax(int[] nums, int p) {
        // 1. Sort the array. This makes it easier to find pairs with small differences. 🗂️
        Arrays.sort(nums);

        // 2. Set the initial range for our binary search. 🔎
        //    - 'left' is the smallest possible difference (0).
        //    - 'right' is the largest possible difference (between the most expensive and cheapest items).
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        // 3. Perform binary search to find the minimum possible maximum difference. ➗
        while (left <= right) {
            // a. Calculate the middle value. This is our "guess" for the maximum difference. 🤔
            int mid = left + (right - left) / 2; // Prevents integer overflow

            // b. Count how many pairs we can form with a maximum difference of 'mid'. 🔢
            int count = 0;
            int i = 0;

            // c. Iterate through the sorted array to form pairs. 🚶‍♀️
            while (i < nums.length - 1) {
                // i. Check if the difference between adjacent numbers is less than or equal to 'mid'. 🧐
                if (nums[i + 1] - nums[i] <= mid) {
                    // If so, we can form a pair, so increment the count and skip the next element. 🎉
                    count++;
                    i++; // Skip the next element as it's already part of a pair
                }
                i++; // Move to the next element in any case
            }

            // d. Adjust the search range based on the count of pairs formed. ⚖️
            // i. If we formed enough pairs (>= p), try to reduce the maximum difference, so we narrow down the right range.
            if (count >= p) {
                right = mid - 1;
            }
            // ii. Otherwise, we need a larger maximum difference, so we narrow down the left range.
            else {
                left = mid + 1;
            }
        }

        // 4. Return the minimum possible maximum difference. 🎁
        return left;
    }
}