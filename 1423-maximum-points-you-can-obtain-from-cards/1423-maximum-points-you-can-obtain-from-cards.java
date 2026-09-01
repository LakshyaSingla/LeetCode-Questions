class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0, rsum = 0;
        int sum = 0;

        for(int i = 0; i < k; i++){
            lsum += cardPoints[i];
        }
        sum = lsum;

        int j = n - 1;
        for(int i = k - 1; i >= 0; i--){
            rsum += cardPoints[j];
            lsum -= cardPoints[i];
            sum = Math.max(sum, rsum + lsum);
            j--;
        }
        return sum;
    }
}