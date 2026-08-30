class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<List<Integer>> ls = new ArrayList<>();
        int i = 0;

        while(i < n && intervals[i][1] < newInterval[0]){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            ls.add(new ArrayList<>(temp));
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
         List<Integer> merge = new ArrayList<>();
        merge.add(newInterval[0]);
        merge.add(newInterval[1]);
        ls.add(merge);

        while(i < n){
             List<Integer> temp = new ArrayList<>();
             temp.add(intervals[i][0]);
             temp.add(intervals[i][1]);
             ls.add(new ArrayList<>(temp));
             i++;
        }
        int[][] ans = new int[ls.size()][2];
        for(int k = 0; k < ans.length; k++){
            ans[k][0] = ls.get(k).get(0);
            ans[k][1] = ls.get(k).get(1);
        }
        return ans;
        
    }
}