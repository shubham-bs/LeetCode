class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] points = new int[10001];

        for(int num: nums){
            points[num] += num;
        }

        int prev1 = 0, prev2 = 0;

        for(int i = 1; i < 10001; i++){
            int curr = Math.max(prev1, points[i] + (i >= 2? prev2: 0));
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}