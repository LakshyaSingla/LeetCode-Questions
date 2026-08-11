class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int longest = 1;
        HashSet<Integer> st = new HashSet<>();
        for(int i = 0; i < n; i++){
            st.add(nums[i]);
        }

        for(int num : st){
            
            if(!st.contains(num - 1)){
                int x = num;
                int count = 1;

                while(st.contains(x + 1)){
                    x = x + 1;
                    count++;
                }
                longest = Math.max(longest, count);
            }            
        }
        return longest;
    }
}