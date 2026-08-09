class Solution {
    void merge(int[] nums, int low, int mid, int high){
        int i = low, j = mid + 1;
        int k = 0;
        int[] temp = new int[high - low + 1];
        while(i <= mid && j <= high){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }
        while(i <= mid){
            temp[k++] = nums[i++];
        }
        while(j <= high){
            temp[k++] = nums[j++];
        }

        for(int l = low; l <= high; l++){
            nums[l] = temp[l - low];
        }
    }
    int countrev(int[] nums, int low, int mid, int high){
       int j = mid + 1;
       int count = 0;
        for(int i = low; i<= mid; i++){
            while(j <= high && (long) nums[i] > (2 * (long) nums[j])){
                j++;
            }
            count += j - (mid + 1);
        }
        return count;
    }
    int mergesort(int[] nums, int low, int high){
        int count = 0;
        if(low >= high) return count;

        int mid = low + ( high - low) / 2;
        count+= mergesort(nums, low, mid);
        count+= mergesort(nums, mid + 1, high);
        count+= countrev(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergesort(nums, 0, n - 1);
    }
}