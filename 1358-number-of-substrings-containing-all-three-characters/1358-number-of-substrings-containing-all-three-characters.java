class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int n = s.length();
        int[] lastSeen = {-1, -1, -1};

        int r = 0;
        while(r < n){
            lastSeen[s.charAt(r) - 'a'] = r;
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                count+= 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
            }
            r++;
        }
        return count;

    }
}