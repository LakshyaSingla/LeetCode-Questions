class Solution {
    int[] expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return new int[]{left + 1, right - 1};
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0) return "";
        int left = 0, right = 0;
        for(int i = 0; i < n; i++){
            
            int[] odd = expand(s, i, i);
            int[] even = expand(s, i, i + 1);

            if(odd[1] - odd[0] > right - left){
                right = odd[1];
                left = odd[0];
            }
            if(even[1] - even[0] > right - left){
                right = even[1];
                left = even[0];
            }
            
        }
        return s.substring(left, right + 1);
    }
}