class Solution {
    boolean isPossible(int[] piles, int mid, int h){
        int sum = 0;
        for(int pile : piles){
            sum += Math.ceil((double) pile / (double) mid);
        }
        return sum <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1, high = 0;
        for(int pile : piles){
            high = Math.max(pile, high);
        }   
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(piles, mid, h)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}