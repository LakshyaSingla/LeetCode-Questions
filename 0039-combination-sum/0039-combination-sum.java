class Solution {
    void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> current, int index, int n){
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }
        if(target < 0 || index == n){
            return;
        }

        current.add(candidates[index]);
        backtrack(candidates, target - candidates[index], ans, current, index, n);
        current.remove(current.size() - 1);
        backtrack(candidates, target, ans, current, index + 1, n);


    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int n = candidates.length;
        backtrack(candidates, target, ans, current, 0, n);
        return ans;
    }
}