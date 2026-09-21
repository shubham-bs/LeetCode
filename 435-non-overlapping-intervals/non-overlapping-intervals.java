class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int ans = 0;

        if(n <= 1) return ans;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int i = 1;
        int prevEnd = intervals[0][1];
        while(i < n){
            if(prevEnd > intervals[i][0]){
                ans++;
            }else prevEnd = intervals[i][1];
            i++;
        }

        return ans;
    }
}