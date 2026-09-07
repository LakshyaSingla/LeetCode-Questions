class Solution {
    int totalHours(int mid, int[] piles){
        int sum = 0;
        for(int i = 0; i < piles.length; i++){
            sum += Math.ceil((double) piles[i] / (double) mid);
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        
        int maxi = 0;
        for(int num : piles){
            maxi = Math.max(maxi, num);
        }
        int low = 1, high = maxi;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(totalHours(mid, piles) <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}