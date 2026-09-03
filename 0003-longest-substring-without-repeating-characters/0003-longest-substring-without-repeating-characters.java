class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        int l = 0, r = 0, maxlen = 0;
        Arrays.fill(hash, -1);
        while(r < s.length()){
            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)] + 1;
                }
            }
            int len = r - l + 1;
            maxlen = Math.max(maxlen, len);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxlen;
    }
}