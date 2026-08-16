class Solution {
    void backtrack(int index, int n, List<Integer> curr, List<List<Integer>> ans,int[] candidates, int target){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || index == n) return;

        curr.add(candidates[index]);
        backtrack(index + 1, n, curr, ans, candidates, target - candidates[index]);
        curr.remove(curr.size() - 1);
        for(int i = index + 1; i < n; i++){
            if(candidates[i] != candidates[index]){
                backtrack(i, n, curr,ans, candidates, target);
                break;
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        int n = candidates.length;
        List<Integer> curr = new ArrayList<>();
        backtrack(0, n, curr, ans, candidates, target);
        return ans;
    }
}