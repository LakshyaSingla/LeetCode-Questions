class Solution {
    int findMaxRow(int col, int[][] mat){
        int maxIndex = -1, maxRow = Integer.MIN_VALUE;
        for(int i = 0; i < mat.length; i++){
            if(mat[i][col] > maxRow){
                maxRow = mat[i][col];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = m - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int row = findMaxRow(mid, mat);
            int left = (mid > 0) ? mat[row][mid - 1] : -1;
            int right = (mid < m - 1) ? mat[row][mid + 1] : -1;
            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[]{row, mid};
            }else if(mat[row][mid] < left){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}