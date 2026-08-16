class Solution {
    void backtrack(int start, int k, int n, List<List<Integer>> ans,List<Integer> curr){
        if(n == 0 && curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(n < 0 || curr.size() > k) return;
        for(int i = start; i <= 9; i++){
            if(i > n) break;
            curr.add(i);
            backtrack(i + 1, k, n - i, ans, curr);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(1, k, n, ans,curr);
        return ans;
    }
}