class Solution {
    boolean isPossible(int[] nums, int mid, int k){
        long sum = 0;
        for(int num : nums){
            sum += Math.ceil((double) num / (double) mid);
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
            if(isPossible(nums, mid, threshold)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}