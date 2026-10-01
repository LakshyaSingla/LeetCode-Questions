class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n = nums1.length;
        int m = nums2.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = m - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            if(st.isEmpty()) mpp.put(nums2[i], -1);
            else mpp.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = mpp.get(nums1[i]);
        }
        return ans;
    }
}