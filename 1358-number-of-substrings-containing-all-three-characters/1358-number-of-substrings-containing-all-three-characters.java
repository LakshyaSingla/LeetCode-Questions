class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] lastSeen = {-1, -1, -1};
        int r = 0, sum = 0;
        while(r < n){
            lastSeen[s.charAt(r) - 'a'] = r;
            sum += 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            r++;
        }
        return sum;
    }
}