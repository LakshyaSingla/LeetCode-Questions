class Solution {
    boolean isPossible(int mid, int[] piles, int h){
        int count = 0;
        for(int i = 0; i < piles.length; i++){
            count += Math.ceil((double) piles[i] / (double) mid);
            if(count > h) break;
        }
        return count <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int maxi=0;
        for(int num : piles){
            maxi = Math.max(maxi, num);
        }
        int high = maxi;
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