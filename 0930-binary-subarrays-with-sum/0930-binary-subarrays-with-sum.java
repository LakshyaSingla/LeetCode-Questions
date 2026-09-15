class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return NoOfSubArrays(nums, goal) - NoOfSubArrays(nums, goal - 1);        
    }
    int NoOfSubArrays(int[] nums, int goal){
       if(goal < 0) return 0;
       int l = 0, r = 0, sum = 0, count = 0;
       int n = nums.length;
       while(r < n){
        sum += nums[r];
        while(sum > goal){
            sum-= nums[l];
            l++;
        }
        count+= r - l + 1;
        r++;
       } 
       return count;
    }
}