class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] hash = new int[256];
        for(int i = 0; i < m; i++){
            hash[t.charAt(i)]++;
        }
        int l = 0, r = 0, count = 0, minlen = Integer.MAX_VALUE, sIndex = -1;
        while(r < n){
            if(hash[s.charAt(r)] > 0){
                count++;
            }
            hash[s.charAt(r)]--;
            while(count == m){
                 
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0){
                    count--;
                }
                sIndex = l;
                 minlen = Math.min(minlen, r-l+1);
                l++;
                
            }
           
            r++;
        }
        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minlen);
    }
}