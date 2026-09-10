class Solution {
    boolean isPossible(int mid, int[] bloomDay, int m, int k){
        int count = 0, noOfB = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= mid){
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
        int low = Integer.MAX_VALUE, high = 0;
        if((long) m * k > bloomDay.length) return -1;
        for(int num : bloomDay){
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, bloomDay, m,k)){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}