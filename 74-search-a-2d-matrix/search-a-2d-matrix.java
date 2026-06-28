class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length -1;
        int mid = 0;

        while(low <= high){
            mid = low + (high -low) /2;
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] > target){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        
        if(high < 0){
            return false;
        }

        int row = high;
        if(target < matrix[row][0] || target > matrix[row][matrix[row].length -1]){
            return false;
        }

        low = 0;
        high = matrix[row].length -1;
        while(low <= high){
            int newMid = low + (high -low) /2;
            if(matrix[row][newMid] == target){
                return true;
            }else if(matrix[row][newMid] > target){
                high = newMid -1;
            }else{
                low = newMid +1;
            }
        }
        return false;
    }
}