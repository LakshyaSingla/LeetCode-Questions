class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int num : nums1){
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }
    List<Integer> ls = new ArrayList<>();
        for(int num : nums2){
            int count = mpp.getOrDefault(num, 0);
            if(count > 0){
                ls.add(num);
                mpp.put(num, count - 1);
            }
        }
        
        int[] ans = new int[ls.size()];
        for(int i = 0; i < ls.size(); i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
}