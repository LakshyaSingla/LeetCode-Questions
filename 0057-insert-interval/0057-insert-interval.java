class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            i++;
            ans.add(new ArrayList<>(temp));
        }

        while(i < n && newInterval[1] >= intervals[i][0]){
            
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        List<Integer> merge = new ArrayList<>();
        merge.add(newInterval[0]);
        merge.add(newInterval[1]);
        ans.add(merge);

        while(i < n){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            i++;
            ans.add(new ArrayList<>(temp));
        }

        int[][] res = new int[ans.size()][2];
        
        for(int j = 0; j < ans.size(); j++){
            res[j][0] = ans.get(j).get(0);
            res[j][1] = ans.get(j).get(1);
        }
        return res;
    }
}