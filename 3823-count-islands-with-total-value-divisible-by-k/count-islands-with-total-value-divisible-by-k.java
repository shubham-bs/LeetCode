class Solution {

    int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0){
                    long sum = dfs(grid, i, j);
                    if(sum % k == 0) ans++;
                }
            }
        }

        return ans;
    }

    private long dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        long sum = grid[i][j];
        grid[i][j] = 0;

        for(int[] dir: dirs){
            int di = i + dir[0];
            int dj = j + dir[1];

            if(
                di >= 0 && di < m &&
                dj >= 0 && dj < n &&
                grid[di][dj] > 0
            ) sum += dfs(grid, di, dj);
        }

        return sum;
    }
}