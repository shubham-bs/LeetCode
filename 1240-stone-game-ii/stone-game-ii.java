class Solution {
    private int[] suffixSums;
    private int[][] memo;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffixSums = new int[n +1];

        for(int i = n -1; i >= 0; i--){
            suffixSums[i] = suffixSums[i +1] + piles[i];
        }

        memo = new int[n][n +1];

        for(int[] row: memo){
            Arrays.fill(row, -1);
        }

        return dp(0, 1);
    }

    private int dp(int idx, int m){
        if(idx >= n) return 0;

        if(idx + 2 * m > n) return suffixSums[idx];

        if(memo[idx][m] >= 0) return memo[idx][m];

        int maxStones = 0;

        for(int k = 1; k <= 2 * m; k++){
            int opponent = dp(idx +k, Math.max(m, k));
            int curr = suffixSums[idx] - opponent;

            maxStones = Math.max(maxStones, curr);
        }

        return memo[idx][m] = maxStones;
    }
}