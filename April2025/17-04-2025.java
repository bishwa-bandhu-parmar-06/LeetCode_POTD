
// 2176. Count Equal and Divisible Pairs in an Array

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> pos = new HashMap<>();
        int count = 0;
        
        // Step 1: Group numbers by their values (village)
        for (int i = 0; i < nums.length; i++) {
            // Step 2: Check only within the same group (same number)
            for (int j : pos.getOrDefault(nums[i], new ArrayList<>())) {
                if ((i * j) % k == 0) {
                    count++;
                }
            }
            // Step 3: Add current index to the list for the number
            pos.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }
        
        return count;
    }
}