class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                
                if(grid[i][j] == 1){
                    ans += perimeter(grid, i, j);
                }
            }
        }
        return ans;
    }

    private int perimeter(int[][] grid, int i, int j){
        int res = 4;

        if(i > 0 && grid[i -1][j] == 1) res--;
        if(i < grid.length - 1 && grid[i +1][j] == 1) res--;
        if(j > 0 && grid[i][j -1] == 1) res--;
        if(j < grid[0].length -1 && grid[i][j +1] == 1) res--;

        return res;
    }
}