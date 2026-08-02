class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> st = new HashSet<>();

        for(int num : nums1){
            st.add(num);
        }
        HashSet<Integer> st2 = new HashSet<>();
        for(int num : nums2){
            if(st.contains(num)){
                st2.add(num);
            }
        }
        int[] ans = new int[st2.size()];
        int i = 0;
        for(int num : st2){
            ans[i++] = num;
        }
        return ans;
    }
}