class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();

        for(int num : nums) st.add(num);
        int longest = 0;
        for(int num : st){
            if(!st.contains(num - 1)){
                int x = num;
                int count = 1;
                while(st.contains(x + 1)){
                    x = x + 1;
                    count++;
                }
                longest = Math.max(count, longest);
            }
        }
        return longest;
    }
}