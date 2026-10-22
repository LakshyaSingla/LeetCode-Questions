class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] hash = new int[26];
        int l = 0, r = 0, maxfreq = 0, max = 0;
        while(r < n){
            hash[s.charAt(r) - 'A']++;
            maxfreq = Math.max(maxfreq, hash[s.charAt(r) - 'A']);

            if((r - l + 1) - maxfreq > k){
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}