// Sum of subarray minimum
// Difficulty: MediumAccuracy: 46.92%Submissions: 22K+Points: 4Average Time: 30m
// Given an array arr[] of positive integers, find the total sum of the minimum elements of every possible subarrays.

// Note: It is guaranteed that the total sum will fit within a 32-bit unsigned integer.


class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int res = 0;
        for(int i=0; i<arr.length; i++){
            int min = arr[i];
            res += min;
            for(int j=i+1; j<arr.length; j++){
                min = Math.min(min, arr[j]);
                res += min;
            }
        }
        return res;
    }
}
