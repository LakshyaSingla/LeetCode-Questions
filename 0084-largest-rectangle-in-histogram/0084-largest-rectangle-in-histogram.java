class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int max = 0, area = 0, nse = n, pse = -1;
        for(int i = 0; i < n; i++){

            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int x = st.pop();
                nse = i;
                pse = (!st.isEmpty()) ? st.peek() : -1;
                area = heights[x] * (nse - pse - 1);
                max = Math.max(max, area);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int x = st.pop();
            nse = n;
            pse = (!st.isEmpty()) ? st.peek() : -1;
            area = heights[x] * (nse - pse - 1);
            max = Math.max(area, max);
        }
        return max;
    }
}