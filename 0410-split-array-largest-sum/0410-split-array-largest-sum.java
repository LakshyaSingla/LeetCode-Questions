class Solution {
    boolean isPossible(int mid, int[] nums, int k){
        int count = 1, subsum = 0;
        for(int i = 0; i < nums.length; i++){
            if(subsum + nums[i] <= mid){
                subsum += nums[i];
            }else{
                count++;
                subsum = nums[i];
            }
        }
        return count <= k; 
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(n < k) return -1;

        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0; i < n; i++){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, nums, k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}