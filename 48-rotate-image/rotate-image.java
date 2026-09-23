class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n; i++){
            for(int j = i +1; j < n; j++){
                swap(matrix, i, j, j, i);
            }
        }

        for(int i = 0; i < n; i++){
            int l = 0;
            int r = n -1;

            while(l < r){
                swap(matrix, i, l, i, r);
                l++;
                r--;
            }
        }
    }
    
    private void swap(int[][] matrix, int a, int b, int c, int d){
        int temp = matrix[a][b];
        matrix[a][b] = matrix[c][d];
        matrix[c][d] = temp;
    }
}