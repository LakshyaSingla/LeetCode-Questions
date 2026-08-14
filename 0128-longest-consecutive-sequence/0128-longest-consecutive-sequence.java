class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            st.add(nums[i]);
        }
        for(int num : st){
            if(!st.contains(num - 1)){
                int count = 1;
                int x = num;
                while(st.contains(x + 1)){
                    x = x + 1;
                    count++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}