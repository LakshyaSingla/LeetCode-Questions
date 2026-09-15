class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = {-1, -1, -1};
        int n = s.length();
        int  r = 0;
        int count = 0;
        while(r < n){
            lastSeen[s.charAt(r) - 'a'] = r;
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                count += 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            }
            r++;
        }
        return count;
    }
}