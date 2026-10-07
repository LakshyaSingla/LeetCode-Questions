class Solution {
    List<Integer> genRow(int row){
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long res = 1;
        for(int i = 1; i < row; i++){
            res *= (row - i);
            res /= i;
            ans.add((int) res);
        }
        return ans;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i <= numRows; i++){
            ans.add(genRow(i));
        }
        return ans;
    }
}