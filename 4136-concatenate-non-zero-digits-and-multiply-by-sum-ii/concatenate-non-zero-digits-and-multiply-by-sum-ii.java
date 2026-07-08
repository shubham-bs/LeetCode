class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] sumD = new int[n + 1];
        int[] cntN0 = new int[n + 1];
        long[] prefixNum = new long[n + 1];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 1; i <= n; i++) {
            int d = s.charAt(i - 1) - '0';

            sumD[i] = sumD[i - 1] + d;
            cntN0[i] = cntN0[i - 1] + (d == 0 ? 0 : 1);

            if (d == 0) {
                prefixNum[i] = prefixNum[i - 1];
            } else {
                prefixNum[i] = (prefixNum[i - 1] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int nonZeroCnt = cntN0[r + 1] - cntN0[l];
            int digitSum = sumD[r + 1] - sumD[l];

            long x = (prefixNum[r + 1]
                    - (prefixNum[l] * pow10[nonZeroCnt]) % MOD
                    + MOD) % MOD;

            ans[i] = (int) ((x * digitSum) % MOD);
        }

        return ans;
    }
}