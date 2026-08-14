class Solution {
    void backtrack(int index, int[] nums, int n,List<List<Integer>> ans, List<Integer> curr){
        if(index == n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        backtrack(index + 1, nums, n, ans, curr);
        curr.remove(curr.size() - 1);
        for(int i = index + 1; i < n; i++){
            if(nums[i] != nums[index]){
                backtrack(i, nums, n, ans, curr);
                return;
            }
        }
        backtrack(n, nums, n, ans, curr);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, nums.length, ans, curr);
        return ans;
    }
}