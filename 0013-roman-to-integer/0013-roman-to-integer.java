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
        int n = s.length();
        int total=0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(i < n - 1 && mpp.get(c) < mpp.get(s.charAt(i + 1))){
                total -= mpp.get(c);
            }else{
                total += mpp.get(c);
            }
        }
        return total;
    }
}