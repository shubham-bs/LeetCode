class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 0) dfs(grid, i, 0);
            if(grid[i][n -1] == 0) dfs(grid, i, n -1);
        }
        for(int j = 0; j < n; j++){
            if(grid[0][j] == 0) dfs(grid, 0, j);
            if(grid[m -1][j] == 0) dfs(grid, m -1, j);
        }

        int ans = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        grid[i][j] = 1;

        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for(int[] dir: dirs){
            int di = i + dir[0];
            int dj = j + dir[1];

            if(
                di >= 0 && di < m &&
                dj >= 0 && dj < n &&
                grid[di][dj] == 0
            ) dfs(grid, di, dj);
        }
    }
}