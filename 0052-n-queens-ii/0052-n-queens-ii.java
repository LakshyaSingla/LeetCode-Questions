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
    int eachRow(int row,List<String> ansRow){
        
        if(row == ansRow.size()){  
            return 1;
        }
        int ans = 0;
        for(int col = 0; col < ansRow.get(row).length(); col++){
            
            if(isValid(ansRow, row, col)){
                char[] arr = ansRow.get(row).toCharArray();
                arr[col] = 'Q';
                ansRow.set(row, new String(arr));
                ans+= eachRow(row + 1, ansRow);
                arr[col] = '.';
                ansRow.set(row, new String(arr));
            }
        }
        return ans;
       
        
    } 
    public int totalNQueens(int n) {
        List<String> ansRow = new ArrayList<>();
        
        String temp = "";
        for(int i = 0; i < n; i++){
            temp+='.';
        }
        for(int i = 0; i < n; i++){
            ansRow.add(temp);
        }
        return eachRow(0, ansRow);
        
    }
}