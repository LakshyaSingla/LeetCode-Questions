class Solution {
    public String minWindow(String s, String t) {
        int sIndex = -1, minlen = Integer.MAX_VALUE, count = 0;
        int n = s.length();
        int m = t.length();
        int[] hash = new int[256];
        for(int i = 0; i < m; i++){
            hash[t.charAt(i)]++;
        }
        int l = 0, r = 0;
        while(r < n){
            if(hash[s.charAt(r)] > 0){
                count++;
            }
            hash[s.charAt(r)]--;

            while(count == m){
                if(r - l + 1 < minlen){
                    minlen = r - l + 1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0){
                    count--;
                }
                l++;
            }
            r++;
        }
        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minlen);

    }
}