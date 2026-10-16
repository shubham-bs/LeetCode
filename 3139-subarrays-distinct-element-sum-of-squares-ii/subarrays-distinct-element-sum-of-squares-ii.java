class Solution {
    static final long MOD = 1_000_000_007L;

    long[] sum;
    long[] sumSq;
    long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        long ans = 0;

        for (int r = 0; r < n; r++) {
            int x = nums[r];
            int prev = last[x];

            update(1, 0, n - 1, prev + 1, r);

            last[x] = r;

            ans = (ans + sumSq[1]) % MOD;
        }

        return (int) ans;
    }

    private void update(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, 1);
            return;
        }

        push(node, l, r);

        int mid = l + (r - l) / 2;

        if (ql <= mid) {
            update(node * 2, l, mid, ql, qr);
        }

        if (qr > mid) {
            update(node * 2 + 1, mid + 1, r, ql, qr);
        }

        pull(node);
    }

    private void apply(int node, int l, int r, long val) {
        long len = r - l + 1;

        // newSumSq =
        // oldSumSq + 2 * val * oldSum + val^2 * len

        sumSq[node] = (
            sumSq[node]
            + 2 * val % MOD * sum[node] % MOD
            + val * val % MOD * len % MOD
        ) % MOD;

        sum[node] = (
            sum[node] + val * len
        ) % MOD;

        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void push(int node, int l, int r) {
        if (lazy[node] == 0 || l == r) {
            return;
        }

        int mid = l + (r - l) / 2;
        long val = lazy[node];

        apply(node * 2, l, mid, val);
        apply(node * 2 + 1, mid + 1, r, val);

        lazy[node] = 0;
    }

    private void pull(int node) {
        sum[node] = (
            sum[node * 2] + sum[node * 2 + 1]
        ) % MOD;

        sumSq[node] = (
            sumSq[node * 2] + sumSq[node * 2 + 1]
        ) % MOD;
    }
}