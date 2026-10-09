class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = matrix[n -1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] next = new int[n];

            for (int j = 0; j < n; j++) {
                int best = dp[j];

                if (j > 0) {
                    best = Math.min(best, dp[j - 1]);
                }

                if (j < n - 1) {
                    best = Math.min(best, dp[j + 1]);
                }

                next[j] = matrix[i][j] + best;
            }

            dp = next;
        }

        int ans = Integer.MAX_VALUE;
        for(int d: dp){
            ans = Math.min(ans, d);
        }

        return ans;
    }
}