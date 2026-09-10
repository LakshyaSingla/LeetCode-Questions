class Solution {
    boolean isPossible(int mid, int[] position, int m){
        int count = 1, lastBall = position[0];
        for(int i = 1; i < position.length; i++){
            if(position[i] - lastBall >= mid){
                count++;
                lastBall = position[i];
            }
        }
        return count >= m;
    }
    public int maxDistance(int[] position, int m) {
        if(m > position.length) return -1;
        int n = position.length;
        Arrays.sort(position);
        int low = 1;
        int high = position[n-1] - position[0];

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(mid, position, m)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
    }
}