// 2529. Maximum Count of Positive Integer and Negative Integer

class Solution {
    public int maximumCount(int[] nums) {
       int n = nums.length;
       int neg = 0;
       int pos = 0;
       for(int i = 0; i < n; i++){
        if(nums[i] < 0){
            neg++;
        }else if(nums[i] > 0){
            pos++;
        }
       }
       if(neg > pos){
        return neg;
       }else{
        return pos;
       } 
    }
}