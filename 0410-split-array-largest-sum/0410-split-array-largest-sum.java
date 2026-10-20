class Solution {
    boolean isPossible(int[] nums, int mid, int k){
        int sum = 0, count = 1;
        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] > mid){
                count++;
                sum = nums[i];
            }else{
                sum += nums[i];
            }
        }
        return count <= k;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = 0;
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(nums, mid, k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}