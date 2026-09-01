class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int count = 1, i = 1;

        while(i < ratings.length){
            if(ratings[i] == ratings[i -1]){
                count++;
                i++;
            }
            int peak = 1;
            while(i < n && ratings[i] > ratings[i - 1]){
                peak++;
                count += peak;
                i++; 
            }
            int down = 1;
            while(i < n && ratings[i] < ratings[i - 1]){
                count+= down;
                down++;
                i++;
            }
            if(down > peak){
                count+= down - peak;
            }
        }
        return count;
    }
}