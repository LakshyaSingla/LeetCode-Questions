class Solution {
    boolean isPossible(int[] bloomDay, int mid, int m, int k){
        int count = 0, noOfB = 0;
        for(int day : bloomDay){
            if(day <= mid){
                count++;
            }else{
                noOfB += count / k;
                count = 0;
            }
        }
        noOfB += count / k;
        return noOfB >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long) m * k > n) return -1;
        int low = Integer.MAX_VALUE, high = 0;
        for(int day : bloomDay){
            low = Math.min(low, day);
            high = Math.max(high, day);
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(bloomDay, mid, m, k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}