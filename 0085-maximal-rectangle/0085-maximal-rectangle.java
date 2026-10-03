class Solution {
    int maxArea(int[] heights){
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
            max = Math.max(max, area);
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        int[] heights = new int[col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '0'){
                    heights[j] = 0;
                }else{
                    heights[j] += 1;
                }
            }
            max = Math.max(max, maxArea(heights));
        }
        return max;

    }
}