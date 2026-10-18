class Solution {
    boolean isPossible(int[] candies, long k, int mid){
        long sum = 0;
        for(int num : candies){
            sum += num / mid;
            if(sum >= k) return true;
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        int low = 1, high = 0;
        for(int num : candies){
            high = Math.max(high, num);
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(candies, k, mid)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
    }
}