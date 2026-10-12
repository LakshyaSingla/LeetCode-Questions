class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int count = 0, sum = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(sum % k == 0) count++;
            int rem = ((sum % k) + k) % k;
            if(mpp.containsKey(rem)){
                count += mpp.get(rem);
            }
            mpp.put(rem, mpp.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}