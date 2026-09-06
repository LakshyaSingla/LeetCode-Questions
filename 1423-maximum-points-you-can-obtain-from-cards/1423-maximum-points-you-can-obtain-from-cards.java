class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0, sum = 0;
        int n = cardPoints.length;
        for(int i = 0; i < k; i++){
            sum += cardPoints[i];
        }
        max = sum;

        int j = n - 1;
        for(int i = k - 1; i >= 0; i--){
            sum-= cardPoints[i];
            sum+= cardPoints[j];
            max = Math.max(max, sum);
            j--;
        }
        return max;
    }
}