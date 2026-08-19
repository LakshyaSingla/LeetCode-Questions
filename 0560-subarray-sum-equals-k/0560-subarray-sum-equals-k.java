class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int count = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum+=nums[i];
            if(sum == k) count++;
            int rem = sum - k;
            if(mpp.containsKey(rem)){
                count += mpp.get(rem);
            }
            
            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}