class Solution {
    boolean isPossible(int[] position, int mid, int m){
        long count = 1, lastball = position[0];
        for(int i = 1; i < position.length; i++){
            if(position[i] - lastball >= mid){
                count++;
                lastball = position[i];
            }
        }
        return count >= m;
    }
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1, high = position[n - 1] - position[0];
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(position, mid, m)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
    }
}