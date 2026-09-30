class Solution {
    int[] PSEE(int[] arr){
        int n =arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(!st.isEmpty()) ans[i] = st.peek();
            else ans[i] = -1;
            st.push(i);
        }
        return ans;
    }
    int[] NSE(int[] arr){
        int n =arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()) ans[i] = st.peek();
            else ans[i] = n;
            st.push(i);
        }
        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int n = arr.length;
        int mod = (int)1e9 + 7;
        int[] PSEE = PSEE(arr);
        int[] NSE = NSE(arr);

        for(int i = 0; i < n; i++){
            long left = i - PSEE[i];
            long right = NSE[i] - i;
            long freq = left * right;
            long val = (arr[i] * freq) % mod;
            sum = (sum + val) % mod;
        }
        return (int) sum;
    }
}