class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[order[i]] = i;
        }

        int LOG = 17;
        while ((1 << LOG) <= n) LOG++;

        int[][] jump = new int[LOG][n];

        // Two pointers: compute farthest reachable in one edge
        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r + 1 < n &&
                    nums[order[r + 1]] - nums[order[l]] <= maxDiff) {
                r++;
            }

            jump[0][l] = r;

            if (r == l) {
                r++;
            }
        }

        // Binary lifting
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = pos[queries[i][0]];
            int v = pos[queries[i][1]];

            if (u > v) {
                int t = u;
                u = v;
                v = t;
            }

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            int cur = u;
            int edges = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (jump[k][cur] < v) {
                    cur = jump[k][cur];
                    edges += 1 << k;
                }
            }

            if (jump[0][cur] < v) {
                ans[i] = -1;
            } else {
                ans[i] = edges + 1;
            }
        }

        return ans;
    }
}