class Solution {
    void backtrack(int index, int n, int[] candidates, int target, List<List<Integer>> ans, List<Integer> curr){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || index == n){
            return;
        }

        curr.add(candidates[index]);
        backtrack(index, n, candidates, target - candidates[index], ans, curr);
        curr.remove(curr.size() - 1);
        backtrack(index + 1, n , candidates, target, ans, curr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(0, candidates.length, candidates, target, ans, curr);
        return ans;
    }
}