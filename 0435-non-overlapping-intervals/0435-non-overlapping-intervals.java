class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1, limit = intervals[0][1];
        for(int[] interval : intervals){
            if(interval[0] >= limit){
                count++;
                limit = interval[1];
            }
        }
        return intervals.length - count;
    }
}