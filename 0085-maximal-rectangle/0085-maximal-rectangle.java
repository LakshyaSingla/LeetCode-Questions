class Solution {
    int largestAreaRec(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int pse = -1, nse = n, max = 0, area = 0;

        for(int i = 0; i < heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int index = st.pop();
                nse = i;
                pse = (!st.isEmpty()) ? st.peek() : -1;
                area = heights[index] * (nse - pse - 1);
                max = Math.max(max, area);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int index = st.pop();
            nse = n;
            pse = (!st.isEmpty()) ? st.peek() : -1;
            area = heights[index] * (nse - pse - 1);
            max = Math.max(max, area);
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[] heights = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '0'){
                    heights[j] = 0;
                }else{
                    heights[j]++;
                }
            }
            max = Math.max(max, largestAreaRec(heights));
        }
        return max;
    }
}