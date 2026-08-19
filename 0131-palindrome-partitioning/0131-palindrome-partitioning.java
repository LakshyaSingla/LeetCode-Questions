class Solution {
    void backtrack(int index, String s, List<List<String>> ans,List<String> curr){
        if(index == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                curr.add(s.substring(index, i + 1));
                backtrack(i + 1,s,ans,curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(0, s, ans, curr);
        return ans;
    }
    boolean isPalindrome(String s, int index, int i){
        while(index < i){
            if(s.charAt(index++) != s.charAt(i--)){
                return false;
            }
        }
        return true;
    }
}