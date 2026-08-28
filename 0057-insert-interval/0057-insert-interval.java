class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> res = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while(i < n && newInterval[0] > intervals[i][1]){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            res.add(new ArrayList<>(temp));
            i++;
        }
        while( i < n && newInterval[1] >= intervals[i][0]){
            
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            
            
            i++;
        }
        List<Integer> newValue = new ArrayList<>();
        newValue.add(newInterval[0]);
        newValue.add(newInterval[1]);
        res.add(newValue);
        while(i < n){
            List<Integer> last = new ArrayList<>();
            last.add(intervals[i][0]);
            last.add(intervals[i][1]);
            res.add(new ArrayList<>(last));
            i++;
        }

        int[][] ans = new int[res.size()][2];
        for(int k = 0; k < ans.length; k++){
            ans[k][0] = res.get(k).get(0);
            ans[k][1] = res.get(k).get(1);
        }
        return ans;
    }
}