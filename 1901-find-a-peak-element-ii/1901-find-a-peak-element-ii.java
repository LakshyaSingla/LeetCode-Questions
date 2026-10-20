class Solution {

    int findMaxRow(int[][] mat, int mid){
        int max = Integer.MIN_VALUE, index = -1;
        for(int i = 0; i < mat.length; i++){
            if(mat[i][mid] > max){
                max = mat[i][mid];
                index = i;
            }
        }
        return index;

    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = m - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int maxRow = findMaxRow(mat, mid);
            int left = (mid > 0) ? mat[maxRow][mid - 1] : -1;
            int right = (mid < m - 1) ? mat[maxRow][mid + 1] : -1;
            if(mat[maxRow][mid] > left && mat[maxRow][mid] > right){
                return new int[]{maxRow, mid};
            }else if(left > mat[maxRow][mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}