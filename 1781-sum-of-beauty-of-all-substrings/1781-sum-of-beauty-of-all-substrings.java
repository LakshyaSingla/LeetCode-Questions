class Solution {
    public int beautySum(String s) {
        int sum = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            int[] hash = new int[26];
            for(int j = i; j < n; j++){
                hash[s.charAt(j) - 'a']++;
                int max = 0, min = Integer.MAX_VALUE;
                for(int freq : hash){
                    if(freq > 0){
                        max = Math.max(max, freq);
                        min = Math.min(min, freq);
                    }
                }
                sum += max - min;
            }
        }
        return sum;
    }
}