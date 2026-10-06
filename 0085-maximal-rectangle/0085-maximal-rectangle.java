class Solution {
    int maxArea(int[] heights){
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int max = 0, area = 0, nse = n, pse = -1;
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int x = st.pop();
                nse = i;
                pse = (!st.isEmpty()) ? st.peek() : -1;
                area = heights[x] * (nse - pse - 1);
                max = Math.max(area, max);
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
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '0'){
                    heights[j] = 0;
                }else{
                    heights[j]++;
                }
            }
            max = Math.max(max, maxArea(heights));
        }
        return max;
    }
}