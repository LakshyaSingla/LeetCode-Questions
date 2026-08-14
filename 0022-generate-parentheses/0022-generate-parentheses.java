class Solution {
    void generate(int open, int close, int n, String curr, List<String> ans ){
        if(open == close && open + close == 2 * n){
            ans.add(curr);
            return;
        }
        if(open < n){
            generate(open + 1, close, n, curr + '(', ans);
        }
        if(close < open){
            generate(open, close + 1, n , curr + ')', ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0,0,n,"", ans);
        return ans;
        
    }
}