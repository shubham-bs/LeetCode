class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);
        int total = m * n; 

        if(k == 0){
            List<List<Integer>> ans = new ArrayList<>(m);

            for(int[] rowArr: grid){
                List<Integer> row = new ArrayList<>(n);

                for(int num: rowArr){
                    row.add(num);
                }
                ans.add(row);
            }
            return ans;
        }

        reverse(grid, 0, total -1, n);
        reverse(grid, 0, k -1, n);
        reverse(grid, k, total - 1, n);

        List<List<Integer>> ans = new ArrayList<>(m);

        for(int[] rowArr: grid){
            List<Integer> row = new ArrayList<>(n);

            for(int num: rowArr){
                row.add(num);
            }
            ans.add(row);
        }

        return ans;
    }

    private void reverse(int[][] grid, int start, int end, int n){
        while(start < end){
            int sr = start / n;
            int sc = start % n;
            int er = end / n;
            int ec = end % n;

            int temp = grid[sr][sc];
            grid[sr][sc] = grid[er][ec];
            grid[er][ec] = temp;
            start++;
            end--;
        }
    }
}