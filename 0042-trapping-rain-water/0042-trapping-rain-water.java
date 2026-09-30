class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int sum = 0;
        int lmax = 0, rmax = 0;

        while(l < r){
            if(height[l] <= height[r]){
                if(lmax > height[l]){
                    sum += lmax - height[l];
                }else{
                    lmax = height[l];
                }
                l++;
            }else{
                if(rmax > height[r]){
                    sum += rmax - height[r];
                }else{
                    rmax = height[r];
                }
                r--;
            }
        }
        return sum;
    }
}