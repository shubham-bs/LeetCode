class Solution {
    private Boolean[][][] memo;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;
        if ((m + n - 1) % 2 != 0) return false;

        int maxBalance = (m + n) / 2;
        memo = new Boolean[m][n][maxBalance + 1];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int balance) {
        if (grid[r][c] == '(') balance++;
        else balance--;

        if (balance < 0 || balance >= memo[0][0].length) return false;
        if (r == m - 1 && c == n - 1) return balance == 0;
        if (memo[r][c][balance] != null) return memo[r][c][balance];

        boolean foundPath = false;
        if (r + 1 < m) foundPath = foundPath || dfs(grid, r + 1, c, balance);
        if (c + 1 < n) foundPath = foundPath || dfs(grid, r, c + 1, balance);

        return memo[r][c][balance] = foundPath;
    }
}
