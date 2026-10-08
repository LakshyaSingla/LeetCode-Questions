class Solution {
    void reverse(int[] nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(nums, 0, n - 1);
            return;
        }
        for(int i = n - 1; i >= 0; i--){
            if(nums[i] > nums[index]){
                swap(nums, i, index);
                break;
            }
        }
        reverse(nums, index + 1, n - 1);

    }
}