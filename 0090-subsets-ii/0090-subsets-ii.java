class Solution {
    void backtrack(int index, int[] nums, List<List<Integer>> ans, List<Integer> curr, int n){

        if(index == n){
            ans.add(new ArrayList<>(curr));
            return;
        }        
        curr.add(nums[index]);
        backtrack(index + 1, nums, ans, curr,n);
        curr.remove(curr.size() - 1);
        for(int i = index + 1; i < n; i++){
            if(nums[i] != nums[index]){
                backtrack(i, nums, ans, curr, n);
                return;
            }
        }
        backtrack(n, nums, ans, curr, n);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        backtrack(0, nums, ans, curr, n);
        return ans;
    }
}