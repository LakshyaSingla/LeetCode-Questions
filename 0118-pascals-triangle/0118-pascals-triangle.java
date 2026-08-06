class Solution {
    List<Integer> oneRow(int row){
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        int res = 1;
        for(int col = 1; col < row; col++){
            res *= (row - col);
            res /= col;
            ansRow.add(res);
        }
        return ansRow;
        
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int row = 1; row <= numRows; row++){
            ans.add(oneRow(row));
        }
        return ans;
    }
}