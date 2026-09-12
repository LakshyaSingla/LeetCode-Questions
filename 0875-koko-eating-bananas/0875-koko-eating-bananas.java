class Solution {
    boolean isPossible(int mid, int[] piles, int h){
        int hours = 0;
        for(int i = 0; i < piles.length; i++){
            hours += Math.ceil((double) piles[i] / (double) mid);
            if(hours > h) return false;
        }
        return (hours <= h);
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for(int pile : piles){
            high = Math.max(pile, high);
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, piles, h)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}