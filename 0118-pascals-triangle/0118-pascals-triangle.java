class Solution {
    public List<Integer> genRow(int row){
        List<Integer> ansRow = new ArrayList<>();
        long res = 1;
        ansRow.add(1);
        for(int i = 1; i < row; i++){
            res*= row-i;
            res/= i;
            ansRow.add((int)res);
        }
        return ansRow;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            ans.add(genRow(i));
        }
        return ans;
    }
}