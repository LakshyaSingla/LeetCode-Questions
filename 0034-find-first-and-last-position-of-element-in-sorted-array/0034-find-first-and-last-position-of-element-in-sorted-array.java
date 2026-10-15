class Solution {
    int firstOccurence(int[] nums, int k){
        int low = 0, high = nums.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == k){
                ans = mid;
                high = mid - 1;
            }else if(nums[mid] < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    int lastOccurence(int[] nums, int k){
        int low = 0, high = nums.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == k){
                ans = mid;
                low = mid + 1;
            }else if(nums[mid] < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurence(nums, target);
        if(first == -1) return new int[]{-1, -1};
        int last = lastOccurence(nums, target);
        return new int[]{first, last};
    }
}