class Solution {
    private static final String[] MAP = {
        "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    void backtrack(int index, String digits, List<String> ans, StringBuilder curr){
        if(index == digits.length()){
            ans.add(curr.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letter = MAP[digit];
        for(int i = 0 ; i < letter.length(); i++){
            curr.append(letter.charAt(i));
            backtrack(index + 1, digits, ans, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
       
       backtrack(0, digits,ans,  new StringBuilder());
       return ans;
    }
}