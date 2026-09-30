class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int max = 0, area = 0, pse = -1, nse = n;
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int index = st.pop();
                int value = heights[index];
                nse = i;
                pse = (!st.isEmpty()) ? st.peek() : -1;
                area = value * (nse - pse - 1);
                max = Math.max(max, area); 
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