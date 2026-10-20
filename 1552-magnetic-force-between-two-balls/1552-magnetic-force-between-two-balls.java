class Solution {
    boolean isPossible(int[] nums, int mid, int m){
        int count = 1, lastBall = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - lastBall >= mid){
                count++;
                lastBall = nums[i];
            }
        }
        return count >= m;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1, high =  position[n - 1] - position[0];
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(position, mid, m)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
    }
}