class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] nextDp = new long[k];
            int v = num % k;
            
            for (int x = 0; x < k; x++) {
                if (dp[x] > 0) {
                    nextDp[(x * v) % k] += dp[x];
                }
            }
            
            nextDp[v]++;
            
            for (int x = 0; x < k; x++) {
                ans[x] += nextDp[x];
            }
            
            dp = nextDp;
        }

        return ans;
    }
}
