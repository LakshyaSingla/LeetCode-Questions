class Solution {
    void search(int index, String s, List<List<String>> ans,List<String> curr){
        if(index == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
            curr.add(s.substring(index, i + 1));
            search(i + 1, s, ans, curr);
            curr.remove(curr.size() - 1);
        }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        search(0, s, ans, curr);
        return ans;
    }
    boolean isPalindrome(String s, int first, int last){
        while(first < last){
            if(s.charAt(first++) != s.charAt(last--)){
                return false;
            }
        }
        return true;
    }
}