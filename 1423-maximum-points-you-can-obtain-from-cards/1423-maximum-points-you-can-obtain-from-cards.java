class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0, rsum = 0;
        for(int i = 0; i < k; i++){
            lsum += cardPoints[i];
        }
        int sum = lsum;
        int i = n - 1;
        for(int j = k - 1; j >= 0; j--){
            lsum -= cardPoints[j];
            rsum += cardPoints[i--];
            sum = Math.max(sum, lsum + rsum);
        }
        return sum;
    }
}