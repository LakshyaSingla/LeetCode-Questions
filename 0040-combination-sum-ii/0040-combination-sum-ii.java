class Solution {
    void backtrack(int index, int[] candidates, int n, int target, List<List<Integer>> ans,List<Integer> curr ){

        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || index == n) return ;

        curr.add(candidates[index]);
        backtrack(index + 1, candidates,n, target - candidates[index], ans, curr);
        curr.remove(curr.size() - 1);
        for(int i = index + 1; i < n; i++){
            if(candidates[i] != candidates[index]){
                backtrack(i, candidates, n, target, ans, curr);
                return;
            }
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, candidates.length, target, ans, curr);
        return ans;
    }
}