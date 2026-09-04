class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int r = 1, sum = 1;

        while(r < n){
            if(ratings[r] == ratings[r - 1]){
                sum++;
                r++;
            }
            int peak = 1;
        while(r < n && ratings[r] > ratings[r - 1]){
            peak++;
            sum += peak;
            r++;
        }
        int down = 1;
        while(r < n && ratings[r] < ratings[r-1]){
            sum+= down;
            down++;
            r++;
        }
        if(down > peak){
            sum+= down - peak;
        }
    }
    return sum;
}
}