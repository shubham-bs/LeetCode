class Solution {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix[0].length;
        int col = matrix.length;
        int[][] arr = new int[rows][col];

        for(int i =0; i < col; i++){
            for(int j = 0; j < rows; j++){
                arr[j][i] = matrix[i][j];
            }
        }

        return arr;
        
    }
}