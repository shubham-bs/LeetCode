class Solution {

    static final int MOD = 1_000_000_007;

    int m, n;
    int[][] grid;

    int[][][] memo;
    boolean[][][] seen;

    public int uniquePaths(int[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n][2];
        seen = new boolean[m][n][2];

        long[][] dp = new long[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dp[i][j] == 0) {
                    continue;
                }

                long ways = dp[i][j];

                int right = resolve(i, j + 1, 0);

                if (right != -1) {
                    int x = right / n;
                    int y = right % n;

                    dp[x][y] =
                        (dp[x][y] + ways) % MOD;
                }

                int down = resolve(i + 1, j, 1);

                if (down != -1) {
                    int x = down / n;
                    int y = down % n;

                    dp[x][y] =
                        (dp[x][y] + ways) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }

    private int resolve(int i, int j, int dir) {

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return -1;
        }

        if (grid[i][j] == 0) {
            return i * n + j;
        }

        if (seen[i][j][dir]) {
            return memo[i][j][dir];
        }

        seen[i][j][dir] = true;

        int nextDir = 1 - dir;

        int ni = i;
        int nj = j;

        if (nextDir == 0) {
            nj++;
        } else {
            ni++;
        }

        memo[i][j][dir] =
            resolve(ni, nj, nextDir);

        return memo[i][j][dir];
    }
}