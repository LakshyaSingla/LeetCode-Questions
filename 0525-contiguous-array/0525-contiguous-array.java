class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            sum += (nums[i] == 0) ? -1 : 1;
            if(sum == 0) max = Math.max(max, i + 1);

            if(mpp.containsKey(sum)){
                max = Math.max(max, i - mpp.get(sum));
            }else{
                mpp.put(sum, i);
            }
        }
        return max;
    }
}