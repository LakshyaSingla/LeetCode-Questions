class Solution {
    void backtrack(int index, int n, int[] nums, List<List<Integer>> ans, List<Integer> curr){

        if(index == n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        backtrack(index + 1, n, nums, ans, curr);
        curr.remove(curr.size() - 1);
        backtrack(index + 1, n, nums, ans, curr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr= new ArrayList<>();
        backtrack(0, nums.length, nums, ans, curr);
        return ans;
    }
}