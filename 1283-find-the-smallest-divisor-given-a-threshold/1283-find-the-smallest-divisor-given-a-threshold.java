class Solution {
    boolean isPossible(int mid, int[] nums, int k){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += Math.ceil((double) nums[i]/ (double) mid);
            if(sum > k) return false;
        }
        return sum <= k;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;
        for(int num : nums){
            high = Math.max(high, num);
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, nums, threshold)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}