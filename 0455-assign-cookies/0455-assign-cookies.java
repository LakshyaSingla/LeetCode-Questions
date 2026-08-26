class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length;
        int n = s.length;
        int l = 0, r = 0;
        while(l < m && r < n){
            if(g[l] <= s[r]){
                l++;
            }
            r++;
        }
        return l;
    }
}