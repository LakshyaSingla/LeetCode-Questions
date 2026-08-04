class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long res = 1;
        for(int col = 1; col <= rowIndex; col++){
            res *= rowIndex + 1 - col;
            res /= col;
            ans.add((int) res);
        }
        return ans;
    }
}