class Solution {
    boolean isPossible(int mid, int[] nums, int k){
        int count = 1, sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] <= mid){
                sum += nums[i];
            }else{
                count++;
                sum = nums[i];
            }
        }
        return count <= k;
    }
    public int splitArray(int[] nums, int k) {
        int low = nums[0], high = 0;
        int n = nums.length;
        if(n < k) return -1;
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }
        while(low <= high){
            int mid = low + (high- low)/ 2;
            if(isPossible(mid, nums, k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}