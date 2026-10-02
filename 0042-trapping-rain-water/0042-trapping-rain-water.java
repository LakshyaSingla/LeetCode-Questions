class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lmax = 0, rmax = 0;
        int left = 0, right = n - 1;
        int sum = 0;
        while(left < right){
            if(height[left] <= height[right]){
                if(lmax > height[left]){
                    sum += lmax - height[left];
                }else{
                    lmax = height[left];
                }
                left++;
            }else{
                if(rmax > height[right]){
                    sum += rmax - height[right];
                }else{
                    rmax = height[right];
                }
                right--;
            }
        }
        return sum;
    }
}