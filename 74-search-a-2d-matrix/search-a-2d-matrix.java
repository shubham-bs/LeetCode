class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row * col -1;

        while(low <= high){
            int mid = low + (high - low) /2;
            if(matrix[mid / matrix[0].length][mid % matrix[0].length] == target){
                return true;
            }else if(matrix[mid /matrix[0].length][mid % matrix[0].length] > target){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return false;
    }
}