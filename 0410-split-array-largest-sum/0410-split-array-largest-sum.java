class Solution {
    boolean isPossible(int[] nums, int mid, int k){
        long sum = 0, count = 1;
        for(int num : nums){
            if(sum + num > mid){
                count++;
                sum = num;
            }else{
                sum += num;
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