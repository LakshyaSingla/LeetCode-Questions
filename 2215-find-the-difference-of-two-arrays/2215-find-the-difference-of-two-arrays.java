class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> st1 = new HashSet<>();
        Set<Integer> st2 = new HashSet<>();
        for(int num : nums1) st1.add(num);
        for(int num : nums2) st2.add(num);

        List<Integer> res1 = new ArrayList<>();
        for(int num : st1){
            if(!st2.contains(num)){
                res1.add(num);
            }
        }
        List<Integer> res2 = new ArrayList<>();
        for(int num : st2){
            if(!st1.contains(num)){
                res2.add(num);
            }
        }

        ans.add(res1);
        ans.add(res2);
        return ans;
    }
}