class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int h = m * n -1;

        while(l <= h){
            int mid = l+ (h - l) /2;
            int x = mid / n;
            int y = mid % n;
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] > target){
                h = mid -1;
            }else{
                l = mid +1;
            }
        }
        return false;
    }
}