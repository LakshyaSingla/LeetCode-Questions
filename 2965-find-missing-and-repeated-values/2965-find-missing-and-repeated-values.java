class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length;
        long N = n * n;
        long s = 0;
        long sn = (N * (N + 1)) / 2;
        long s2 = 0;
        long s2n = (N * (N + 1) * (2 * N + 1)) / 6;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                s+= grid[i][j];
                s2 += (long) grid[i][j] * (long) grid[i][j];
            }
        }
        long val1 = sn - s;
        long val2 = s2n  - s2;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == x){
                    return new int[]{(int) x, (int) y};
                } 
            }
        }
         return new int[]{(int) y, (int) x};
    }
}