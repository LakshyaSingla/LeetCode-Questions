class Solution {
    public int beautySum(String s) {
        int n = s.length();
        long sum = 0;
        for(int i = 0; i < n; i++){
            int[] hash = new int[26];
            for(int j = i; j < n; j++){
                hash[s.charAt(j) - 'a']++;
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                for(int freq : hash){
                    if(freq > 0){
                        max = Math.max(max, freq);
                        min = Math.min(min, freq);
                    }
                }
                sum += max - min;
            }
        }
        return (int) sum;
    }
}