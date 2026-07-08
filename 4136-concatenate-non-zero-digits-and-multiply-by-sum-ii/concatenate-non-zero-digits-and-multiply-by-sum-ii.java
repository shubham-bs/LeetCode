class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] prefixSum = new int[n + 1];
        int[] nonZeroCount = new int[n + 1];
        int[] prefixConcat = new int[n + 1];
        int[] pow10 = new int[n + 1];

        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow10[i] = (int) ((1L * pow10[i - 1] * 10) % MOD);

            int digit = s.charAt(i - 1) - '0';

            prefixSum[i] = prefixSum[i - 1] + digit;
            nonZeroCount[i] = nonZeroCount[i - 1];

            if (digit != 0) {
                nonZeroCount[i]++;
                prefixConcat[i] = (int) ((1L * prefixConcat[i - 1] * 10 + digit) % MOD);
            } else {
                prefixConcat[i] = prefixConcat[i - 1];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int digitSum = prefixSum[r + 1] - prefixSum[l];
            int cnt = nonZeroCount[r + 1] - nonZeroCount[l];

            long concat =
                    (prefixConcat[r + 1]
                    - (1L * prefixConcat[l] * pow10[cnt]) % MOD
                    + MOD) % MOD;

            ans[i] = (int) ((concat * digitSum) % MOD);
        }

        return ans;
    }
}