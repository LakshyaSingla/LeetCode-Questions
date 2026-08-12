class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        int c1 = 0, c2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == ele1){
                c1++;
            }else if(nums[i] == ele2){
                c2++;
            }else if(c1 == 0){
                ele1 = nums[i];
                c1++;
            }else if(c2 == 0){
                ele2= nums[i];
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int num : nums){
            if(num == ele1) c1++;
            if(num == ele2)c2++;
        }
        int mini = nums.length / 3 + 1;
        List<Integer> ans = new ArrayList<>();
        if(c1 >= mini){
            ans.add(ele1);
        }
        if(c2 >= mini){
            ans.add(ele2);
        }
        return ans;
    }
}