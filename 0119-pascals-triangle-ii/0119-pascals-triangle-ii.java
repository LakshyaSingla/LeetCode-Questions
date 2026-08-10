class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long res = 1;
        for(int i = 1; i <= rowIndex; i++){
            res *= (rowIndex - i + 1);
            res /= i;
            ans.add((int) res);
        }
        return ans;
    }
}