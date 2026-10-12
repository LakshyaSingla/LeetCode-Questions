class Solution {
    public void reverseString(char[] s) {
    
        helper(s, 0, s.length - 1);
    }
    void helper(char[] s, int l, int r){
        if(l >= r) return;
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        helper(s, l + 1, r - 1);
    }
}