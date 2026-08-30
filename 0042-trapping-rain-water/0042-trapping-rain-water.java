class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        arr1[0] = height[0];
        for(int i = 1; i < n; i++){
            arr1[i] = Math.max(arr1[i - 1], height[i]);
        }
        arr2[n-1] = height[n-1];
        for(int i = n-2;i>=0; i--){
            arr2[i] = Math.max(arr2[i + 1], height[i]);
        }

        int count = 0;
        for(int i =0;i<n;i++){
            count = count +  Math.min(arr1[i], arr2[i]) - height[i];
        }
        return count;
    }
}