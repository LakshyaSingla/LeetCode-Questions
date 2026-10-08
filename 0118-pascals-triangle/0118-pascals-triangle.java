class Solution {
    List<Integer> genRow(int row){
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        long res = 1;
        for(int i = 1; i < row; i++){
            res *= (row - i);
            res /= i;
            temp.add((int) res);
        }
        return temp;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i <= numRows; i++){
            ans.add(genRow(i));
        }
        return ans;
    }
}