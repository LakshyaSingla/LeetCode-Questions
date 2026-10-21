class Solution {
    boolean isPossible(int[] weights, int mid, int days){
        int day = 1, cap = 0;
        for(int i = 0; i < weights.length; i++){
            if(cap + weights[i] > mid){
                day++;
                cap = weights[i];
            }else{
                cap += weights[i];
            }
        }
        return day <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = 0, high = 0;
        for(int x : weights){
            low = Math.max(low, x);
            high += x;
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(weights, mid, days)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}