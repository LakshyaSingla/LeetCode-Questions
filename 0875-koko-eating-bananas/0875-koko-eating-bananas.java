class Solution {
    int hour(int[] piles, int mid){
        int sum = 0;
        for(int num : piles){
            sum += Math.ceil((double) num / (double) mid);
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for(int num : piles){
            high = Math.max(high, num);
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(hour(piles, mid) <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}