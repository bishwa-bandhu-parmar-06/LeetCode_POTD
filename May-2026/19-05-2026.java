
// 2540. Minimum Common Value


class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {

            // If both are equal, we found the smallest common element
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }

            // Move the smaller value forward
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // No common element found
        return -1;
    }
}