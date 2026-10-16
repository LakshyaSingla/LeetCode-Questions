class Solution {
    int noOfB(int[] bloomDay, int k, int mid){
        int count = 0, sum = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= mid){
                count++;
            }else{
                sum += count / k;
                count = 0;
            }
        }
        sum += count / k;
        return sum;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long) m * k > n) return -1;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int num : bloomDay){
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(noOfB(bloomDay, k, mid) >= m){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}