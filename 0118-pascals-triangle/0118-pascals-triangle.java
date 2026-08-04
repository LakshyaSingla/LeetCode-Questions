class Solution {
    List<Integer> genRow(int row){
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        int ans = 1;

        for(int col = 1; col < row; col++){
            ans *= row - col;
            ans /= col;
            ansRow.add(ans);
        }
        return ansRow;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int row = 1 ; row <= numRows; row++){
            ans.add(genRow(row));
        }
        return ans;
    }
}