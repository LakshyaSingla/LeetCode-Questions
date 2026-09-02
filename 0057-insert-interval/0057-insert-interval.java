class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        List<List<Integer>> res = new ArrayList<>();
        while(i < n && intervals[i][1] < newInterval[0]){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            res.add(new ArrayList<>(temp));
            i++;
        }
        while(i < n && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        List<Integer> insert = new ArrayList<>();
        insert.add(newInterval[0]);
        insert.add(newInterval[1]);
        res.add(insert);

        while(i < n){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            res.add(new ArrayList<>(temp));
            i++;
        }

        int[][] ans= new int[res.size()][2];
        
        
        for(int j = 0; j < res.size(); j++){
            ans[j][0] = res.get(j).get(0);
            ans[j][1] = res.get(j).get(1);
        }
        return ans;

    }
}