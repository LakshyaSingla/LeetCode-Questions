class Solution {
    boolean isPossible(int mid, int[] nums, int k){
        int count = 1, sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] <= mid){
                sum += nums[i];
            }else{
                sum = nums[i];
                count++;
            }
        }
        return count <= k;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(k > n) return -1;
        int low = Integer.MIN_VALUE, high = 0;
        for(int num : nums){
            low = Math.max(num, low);
            high += num;
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