class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowReservations = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                rowReservations.put(row, rowReservations.getOrDefault(row, 0) | (1 << col));
            }
        }
        
        int maxGroups = 2 * n;
        
        int leftBlock   = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5); 
        int middleBlock = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7); 
        int rightBlock  = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9); 
        
        for (int reservedMask : rowReservations.values()) {
            boolean leftFree   = (reservedMask & leftBlock) == 0;
            boolean middleFree = (reservedMask & middleBlock) == 0;
            boolean rightFree  = (reservedMask & rightBlock) == 0;
            
            if (leftFree && rightFree) {
                continue; 
            } else if (leftFree || middleFree || rightFree) {
                maxGroups -= 1;
            } else {
                maxGroups -= 2;
            }
        }
        
        return maxGroups;
    }
}
