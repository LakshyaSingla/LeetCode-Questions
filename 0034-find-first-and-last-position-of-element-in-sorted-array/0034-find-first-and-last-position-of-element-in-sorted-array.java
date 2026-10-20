class Solution {
    int first(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                ans = mid;
                high = mid - 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    int last(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                ans = mid;
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = first(nums, target);
        if(first == -1) return new int[]{-1, -1};
        int sec = last(nums, target);
        return new int[]{first, sec};
    }
}