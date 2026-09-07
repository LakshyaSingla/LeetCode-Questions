class Solution {
    int summation(int mid, int[] nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+= Math.ceil((double) nums[i] / (double) mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        
        int maxi = Integer.MIN_VALUE;
        for(int num : nums){
            maxi = Math.max(maxi, num);
        }
        int low = 1, high = maxi;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(summation(mid, nums) <= threshold){
                
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}