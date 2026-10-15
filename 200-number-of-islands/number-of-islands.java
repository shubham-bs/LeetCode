class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char node = grid[i][j];

                if(node == '1'){
                    dfs(grid, i, j, m, n);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n){
        if(grid[i][j] == '1') grid[i][j] = '0';
        else return;

        if(i +1 < m) dfs(grid, i +1, j, m, n);
        if(i -1 >= 0) dfs(grid, i -1, j, m, n);
        if(j +1 < n) dfs(grid, i, j +1, m, n);
        if(j -1 >= 0) dfs(grid, i, j -1, m, n);
    }
}