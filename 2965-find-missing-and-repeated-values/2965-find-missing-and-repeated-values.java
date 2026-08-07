class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        long N = grid.length;
        long n = N * N;
        long s = 0, s2 = 0;
        long sn = (n * (n + 1)) / 2;
        long s2n = (n * (n + 1) * ((2 * n) + 1)) / 6;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                s+= grid[i][j];
                s2+= (long)grid[i][j] * (long) grid[i][j];

            }
        }
        long val1 = sn -s ;
        long val2 = s2n - s2;
        val2 = val2/val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;

        int c1 = 0, c2 = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
              if(grid[i][j] == x) c1++;
              if(grid[i][j] == y) c2++;
            }
        }
        if(c1 == 2){
            return new int[]{(int)x,(int)y};
        }
        
            return new int[]{(int)y,(int) x};
        
    }
}