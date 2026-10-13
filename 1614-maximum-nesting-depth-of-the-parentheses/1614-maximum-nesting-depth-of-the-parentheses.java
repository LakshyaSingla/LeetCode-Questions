class Solution {
    public int maxDepth(String s) {
        int depth = 0, max = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                depth++;
                max = Math.max(depth,max);
            }else if(s.charAt(i) == ')'){
                depth--;
            }
        }
        return max;
    }
}