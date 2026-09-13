class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        
        List<Integer> ones1 = new ArrayList<>();
        List<Integer> ones2 = new ArrayList<>();
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) {
                    ones1.add(r * 100 + c);
                }
                if (img2[r][c] == 1) {
                    ones2.add(r * 100 + c);
                }
            }
        }
        
        Map<Integer, Integer> vectorCounts = new HashMap<>();
        int maxOverlap = 0;
        
        for (int p1 : ones1) {
            int r1 = p1 / 100;
            int c1 = p1 % 100;
            
            for (int p2 : ones2) {
                int r2 = p2 / 100;
                int c2 = p2 % 100;
                
                int shiftVector = ((r2 - r1) * 100) + (c2 - c1);
                
                int currentCount = vectorCounts.getOrDefault(shiftVector, 0) + 1;
                vectorCounts.put(shiftVector, currentCount);
                
                maxOverlap = Math.max(maxOverlap, currentCount);
            }
        }
        
        return maxOverlap;
    }
}