class Solution {
    boolean isValid(List<String> ansRow, int row, int col){
        int r = row;
        int c = col;
        while(r >= 0){
            if(ansRow.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
        }
        r = row;
        while(r >=0 && c >= 0){
            if(ansRow.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
            c--;
        }
        r = row;
        c = col;
        while(r >= 0 && c < ansRow.size()){
            if(ansRow.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
    void eachRow(int row, List<List<String>> ans,List<String> ansRow){
        if(row == ansRow.size()){
            ans.add(new ArrayList<>(ansRow));
            return;
        }
        for(int col = 0; col < ansRow.get(row).length(); col++){
            
            if(isValid(ansRow, row, col)){
                char[] arr = ansRow.get(row).toCharArray();
                arr[col] = 'Q';
                ansRow.set(row, new String(arr));
                eachRow(row + 1, ans, ansRow);
                arr[col] = '.';
                ansRow.set(row, new String(arr));
            }
        }

    } 
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ansRow = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < n; i++){
            temp+='.';
        }
        for(int i = 0; i < n; i++){
            ansRow.add(temp);
        }
        eachRow(0, ans, ansRow);
        return ans;
    }
}