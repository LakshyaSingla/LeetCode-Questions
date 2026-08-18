class Solution {
    private final static String[] MAP = {
        "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    void backtrack(int index,List<String> ans, String digits, StringBuilder curr){

        if(index == digits.length()){
            ans.add(curr.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letter = MAP[digit];
        for(int i = 0; i < letter.length(); i++){
            curr.append(letter.charAt(i));
            backtrack(index + 1, ans, digits, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        backtrack(0, ans, digits, new StringBuilder());
        return ans;
    }
}