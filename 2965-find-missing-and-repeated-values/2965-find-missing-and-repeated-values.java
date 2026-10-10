class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length;
        long N = n * n;
        long sn = (N * (N + 1)) / 2;
        long s2n = (N * (N + 1) * (2 * N + 1)) / 6;
        long s = 0, s2 = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                s += (long) grid[i][j];
                s2 += (long) grid[i][j] * (long) grid[i][j];
            }
        }
        
        long val1 = s - sn;
        long val2 = (s2 - s2n) / val1;

        long X = (val1 + val2) / 2;
        long Y = X - val1;
        return new int[]{(int) X, (int) Y};
    }
}