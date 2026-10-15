class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> mpp = new HashMap<>();
        mpp.put('I', 1);
        mpp.put('V', 5);
        mpp.put('X', 10);
        mpp.put('L', 50);
        mpp.put('C', 100);
        mpp.put('D', 500);
        mpp.put('M', 1000);
        int total = 0;
        int n = s.length();
        for(int i = 0; i < n ; i++){
            if(i < n - 1 && mpp.get(s.charAt(i)) < mpp.get(s.charAt(i + 1))){
                total -= mpp.get(s.charAt(i));
            }else{
                total += mpp.get(s.charAt(i));
            }
        }
        return total;
    }
}