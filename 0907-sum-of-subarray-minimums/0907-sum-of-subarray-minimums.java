class Solution {
    int[] findPSEE(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    int[] findNSE(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i] = n;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        int[] PSEE = findPSEE(arr);
        int[] NSE = findNSE(arr);
        int n = arr.length;
        int mod = (int)1e9 + 7;
        int sum = 0;
        for(int i = 0; i < n; i++){
            int left = i - PSEE[i];
            int right = NSE[i] - i;
            long freq = left * right * 1L;
            int val = (int)((freq * arr[i] ) % mod);
            sum = (sum + val) % mod;
        }
        return sum;
    }
}