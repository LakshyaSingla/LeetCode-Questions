class Solution {
    void backtrack(int n, int k, List<List<Integer>> ans, List<Integer> curr){
        if(n == 0 && curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(n < 0 || curr.size() > k) return;
        int ele = (curr.isEmpty()) ? 1 : curr.get(curr.size() - 1) + 1;
        for(int i = ele; i <= 9; i++){
            if(i > n) break;
            curr.add(i);
            backtrack(n - i, k, ans, curr);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(n, k, ans, curr);
        return ans;
    }
}