class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return noOfOdds(nums, k) - noOfOdds(nums, k - 1);
    }
    int noOfOdds(int[] nums, int k){
        if(k < 0) return 0;
        int n = nums.length;
        int l = 0, r = 0, sum = 0, count = 0;
        while(r < n){
            sum += nums[r] % 2;
            while(sum > k){
                sum-= nums[l] % 2;
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}