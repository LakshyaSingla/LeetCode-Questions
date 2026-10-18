class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int sum = 0, maxlen = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            sum += (nums[i] == 0) ? -1 : 1;
            if(sum == 0) maxlen = i + 1;
            if(mpp.containsKey(sum)){
                int len = i - mpp.get(sum);
                maxlen = Math.max(maxlen, len);
            }else{
                mpp.put(sum, i);
            }
        }
        return maxlen;
    }
}