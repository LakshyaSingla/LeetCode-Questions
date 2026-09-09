class Solution {
    boolean isPossible(int mid, int[] nums, int threshold){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += Math.ceil((double) nums[i] / (double) mid);
            if(sum > threshold) break;
        }
        return sum <= threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int maxi = 0;
        for(int num : nums){
            maxi = Math.max(maxi, num);
        }
        int high = maxi;
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