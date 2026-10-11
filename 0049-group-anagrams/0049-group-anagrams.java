class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        int n = strs.length;
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
        
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : mpp.entrySet()){
            List<String> temp = entry.getValue();
            ans.add(temp);
        }
        return ans;
    }
}