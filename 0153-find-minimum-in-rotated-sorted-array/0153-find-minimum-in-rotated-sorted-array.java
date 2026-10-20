class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
       
        int ans = Integer.MAX_VALUE;
        int low = 0, high = n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[low] <= nums[high]){
                ans = Math.min(nums[low], ans);
                break;
            }
            if(nums[mid] >= nums[low]){
                low = mid + 1;
            }else{
                ans = Math.min(nums[mid], ans);
                high = mid - 1;
            }
        }
        return ans;
    }
}