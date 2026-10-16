class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int mins = 0;

        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) q.offer(new int[] {i, j});
            }
        }

        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while(!q.isEmpty()){
            int size = q.size();  
            boolean rotted = false;

            for(int i = 0; i < size; i++){

                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] d: dirs){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(
                        nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 1
                    ){
                        grid[nr][nc] = 2;
                        q.offer(new int[] {nr, nc});
                        rotted = true;
                    }    
                }

                System.out.println(Arrays.deepToString(grid));
            }

            if(rotted) mins++;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return mins;
    }
}