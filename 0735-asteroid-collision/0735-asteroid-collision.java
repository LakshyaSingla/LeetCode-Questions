class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ls = new ArrayList<>();
        int n = asteroids.length;

        for(int i = 0; i < n; i++){
            if(asteroids[i] > 0){
                ls.add(asteroids[i]);
            }else{
                while(!ls.isEmpty() && ls.get(ls.size() - 1) > 0 && ls.get(ls.size() - 1) < Math.abs(asteroids[i])){
                    ls.remove(ls.size() - 1);
                }
                if(!ls.isEmpty() && ls.get(ls.size() - 1) == Math.abs(asteroids[i])){
                    ls.remove(ls.size() - 1);
                }else if(ls.isEmpty() || ls.get(ls.size() - 1) < 0){
                    ls.add(asteroids[i]);
                }
            }
        }
        int[] ans = new int[ls.size()];
        for(int i = 0; i < ls.size(); i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
}