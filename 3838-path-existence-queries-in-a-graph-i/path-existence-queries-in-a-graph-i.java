class Solution {

    int[] parent;
    int[] size;

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                union(i, i - 1);
            }
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = find(queries[i][0]) == find(queries[i][1]);
        }

        return ans;
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; // Path halving
            x = parent[x];
        }
        return x;
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if (size[px] < size[py]) {
            parent[px] = py;
            size[py] += size[px];
        } else {
            parent[py] = px;
            size[px] += size[py];
        }
    }
}