class Solution {
    public int totalNumbers(int[] digits) {
        int[] originalCount = new int[10];
        for (int digit : digits) {
            originalCount[digit]++;
        }
        
        int validNumbersCount = 0;
        
        for (int i = 100; i <= 998; i += 2) {
            int d1 = i / 100;          
            int d2 = (i / 10) % 10;  
            int d3 = i % 10;           
            
            originalCount[d1]--;
            originalCount[d2]--;
            originalCount[d3]--;
            
            if (originalCount[d1] >= 0 && originalCount[d2] >= 0 &&
            originalCount[d3] >= 0) {
                validNumbersCount++;
            }
            
            originalCount[d1]++;
            originalCount[d2]++;
            originalCount[d3]++;
        }
        
        return validNumbersCount;
    }
}