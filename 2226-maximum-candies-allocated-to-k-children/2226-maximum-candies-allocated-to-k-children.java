class Solution {
    boolean isPossible(int[] candies, int mid, long k){
        long sum = 0;
        for(int i = 0; i < candies.length; i++){
            sum += candies[i] / mid;
            if(sum >= k) return true;
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int low = 1, high = 0;
        for(int num : candies){
            high = Math.max(high, num);
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(candies, mid, k)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
    }
}