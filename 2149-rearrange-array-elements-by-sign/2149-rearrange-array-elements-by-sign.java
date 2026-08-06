class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int even = 1, odd = 0;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            int ele = nums[i];
            if(ele < 0){
                ans[even] = ele;
                even += 2;
            }else{
                ans[odd] = ele;
                odd += 2;
            }
        }
        return ans;
    }
}