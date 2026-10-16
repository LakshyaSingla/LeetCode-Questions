class Solution {
    int noOfD(int[] weights, int mid){
        int day = 1, capacity = 0;
        for(int i = 0; i < weights.length; i++){
            if(capacity + weights[i] > mid){
                day++;
                capacity = weights[i];
            }else{
                capacity += weights[i];
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int num : weights){
            low = Math.max(low, num);
            high += num;
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(noOfD(weights, mid) <= days){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}