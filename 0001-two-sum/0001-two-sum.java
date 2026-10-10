class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < n; i++){
            int compl = target - nums[i];
            if(mpp.containsKey(compl)){
                return new int[]{mpp.get(compl), i};
            }
            mpp.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}