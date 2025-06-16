// 2016. Maximum Difference Between Increasing Elements

class Solution {
    public int maximumDifference(int[] nums) {
        // gotta understand this shit
        int small= 0;
        int diff=-1;
        for(int large=1;large<nums.length;++large){
            diff=Math.max(diff,nums[large]-nums[small]);
            if(nums[large]<nums[small]) small= large;
        }
        return diff ==0 ? -1 : diff;
    }
}