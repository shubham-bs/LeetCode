class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        int[] divisible = new int[max + 1];
        for (int d = 1; d <= max; d++) {
            for (int m = d; m <= max; m += d) {
                divisible[d] += freq[m];
            }
        }

        long[] gcdCount = new long[max + 1];
        for (int d = max; d >= 1; d--) {
            long pairs = (long) divisible[d] * (divisible[d] - 1) / 2;

            for (int m = d * 2; m <= max; m += d) {
                pairs -= gcdCount[m];
            }

            gcdCount[d] = pairs;
        }

        for (int i = 1; i <= max; i++) {
            gcdCount[i] += gcdCount[i - 1];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1;

            int lo = 1;
            int hi = max;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (gcdCount[mid] >= target) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            ans[i] = lo;
        }

        return ans;
    }
}