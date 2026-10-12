class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        if(strs == null || strs.length == 0) return ans;
        Map<String, List<String>> mpp = new HashMap<>();

        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!mpp.containsKey(key)){
                mpp.put(key, new ArrayList<>());
            }
            mpp.get(key).add(s);
        }
        for(Map.Entry<String, List<String>> entry : mpp.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}