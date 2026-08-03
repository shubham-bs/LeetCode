class Solution {
    public String stoneGameIII(int[] stoneValue) {

        int dp1 = 0; // dp[i+1]
        int dp2 = 0; // dp[i+2]
        int dp3 = 0; // dp[i+3]
        int dp4 = 0; // dp[i+4]

        for (int i = stoneValue.length - 1; i >= 0; i--) {

            int best = Integer.MIN_VALUE;
            int sum = 0;

            // Take 1 stone
            sum += stoneValue[i];
            best = Math.max(best, sum - dp1);

            // Take 2 stones
            if (i + 1 < stoneValue.length) {
                sum += stoneValue[i + 1];
                best = Math.max(best, sum - dp2);
            }

            // Take 3 stones
            if (i + 2 < stoneValue.length) {
                sum += stoneValue[i + 2];
                best = Math.max(best, sum - dp3);
            }

            // Shift the DP window
            dp4 = dp3;
            dp3 = dp2;
            dp2 = dp1;
            dp1 = best;
        }

        if (dp1 > 0)
            return "Alice";
        if (dp1 < 0)
            return "Bob";
        return "Tie";
    }
}