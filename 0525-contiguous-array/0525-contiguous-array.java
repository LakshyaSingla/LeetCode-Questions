class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0, maxlen = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){

            sum += (nums[i] == 0) ? -1 : 1;
            if(sum == 0) maxlen = i + 1;
            if(mpp.containsKey(sum)){
                maxlen = Math.max(maxlen, i - mpp.get(sum));
            }else{
                mpp.put(sum, i);
            }
        }
        return maxlen;
    }
}