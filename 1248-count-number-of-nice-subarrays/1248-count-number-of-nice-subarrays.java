class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return func(nums, k) - func(nums, k - 1);
    }
    int func(int[] nums, int k){
        if(k < 0) return 0;
        int n = nums.length;
        int sum = 0, count = 0;
        int l = 0, r = 0;

        while(r < n){
            sum+= nums[r] % 2;
            while(sum > k){
                sum-= nums[l] % 2;
                l++;
            }
            count+= r - l + 1;
            r++;
        }
        return count;
    }
}