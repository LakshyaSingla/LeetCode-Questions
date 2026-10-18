class Solution {
    boolean isPossible(int[] weights, int days, int mid){
        int capacity = 0, day = 1;
        for(int num : weights){
            if(capacity + num > mid){
                day++;
                capacity = num;
            }else{
                capacity += num;
            }
        }
        return day <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int num : weights){
            low = Math.max(num, low);
            high += num;
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(weights, days, mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}