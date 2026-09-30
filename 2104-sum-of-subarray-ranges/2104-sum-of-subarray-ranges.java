class Solution {
    int[] PSEE(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    int[] PGEE(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    int[] NSE(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i] = n;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    int[] NGE(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i] = n;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    long subArrayMin(int[] nums){
        int[] PSEE = PSEE(nums);
        int[] NSE = NSE(nums);
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            long left = i - PSEE[i];
            long right = NSE[i] - i;
            long val = (left * right) * nums[i];
            sum += val;
        }
        return sum;
    }
    long subArrayMax(int[] nums){
        int[] PGEE = PGEE(nums);
        int[] NGE = NGE(nums);
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            long left = i - PGEE[i];
            long right = NGE[i] - i;
            long val = (left * right) * nums[i];
            sum += val;
        }
        return sum;
    }
    public long subArrayRanges(int[] nums) {
        return subArrayMax(nums) - subArrayMin(nums);
    }
}