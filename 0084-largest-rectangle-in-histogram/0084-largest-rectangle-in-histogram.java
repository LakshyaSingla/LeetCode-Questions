class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int nse = n, pse = -1, max = 0, area = 0;
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int ele = st.pop();
                nse = i;
                pse = (!st.isEmpty()) ? st.peek() : -1;
                area = heights[ele] * (nse - pse - 1);
                max = Math.max(area, max);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int x = st.pop();
            nse = n;
            pse = (!st.isEmpty()) ? st.peek() : -1;
            area = heights[x] * (nse - pse - 1);
            max = Math.max(max, area);
        }
        return max;
    }
}