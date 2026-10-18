class Solution {
    public int maxDepth(String s) {
        int depth = 0, max = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                depth++;
                max = Math.max(depth, max);
            }else if(c == ')'){
                depth--;
            }
        }
        return max;
    }
}