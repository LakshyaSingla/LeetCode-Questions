class Solution {
    void backtrack(int index, int[] nums,List<List<Integer>> ans, List<Integer> temp){
        if(index == nums.length){
            ans.add(new ArrayList<> (temp));
            return;
        }

        temp.add(nums[index]);
        backtrack(index + 1, nums, ans, temp);
        temp.remove(temp.size() - 1);
        backtrack(index + 1, nums, ans, temp);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(0, nums, ans, temp);
        return ans;
    }
}