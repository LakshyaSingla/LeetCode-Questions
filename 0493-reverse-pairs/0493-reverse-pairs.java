class Solution {
    void merge(int[] nums, int low, int mid, int high){
        int i = low, j = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while(i <= mid && j <= high){
            if(nums[i] <= nums[j]){
                temp.add(nums[i]);
                i++;
            }else{
                temp.add(nums[j]);
                j++;
            }
        }
        while(i <= mid){
            temp.add(nums[i]);
                i++;
        }
        while(j <= high){
            temp.add(nums[j]);
            j++;
        }

        for(int k = low; k <= high; k++){
            nums[k] = temp.get(k - low);
        }
    }
    int countValue(int[] nums, int low, int mid , int high){
        int count = 0;
        int j = mid + 1;
        for(int i = low; i <= mid; i++){
            while(j <= high && (long) nums[i] > 2* (long) nums[j]){
                j++;
            }
            count += j - (mid + 1);
        }
        return count;
    }
    int mergesort(int[] nums, int low , int high){
        int count = 0;
        if(low >= high) return count;

        int mid = low + (high - low) / 2;
       count+=  mergesort(nums, low, mid);
       count+=  mergesort(nums, mid + 1, high);
       count+= countValue(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }
    public int reversePairs(int[] nums) {
         return mergesort(nums, 0, nums.length - 1);
    }
}