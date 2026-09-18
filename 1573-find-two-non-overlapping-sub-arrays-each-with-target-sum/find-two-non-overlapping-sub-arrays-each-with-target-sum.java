class Solution {
    public int minSumOfLengths(int[] arr, int target) {
         int n = arr.length;
        
        int[] minLenUpTo = new int[n];
        Arrays.fill(minLenUpTo, Integer.MAX_VALUE / 2); 
        
        int l = 0;
        int currSum = 0;
        int minTotLen = Integer.MAX_VALUE;
        
        for (int r = 0; r < n; r++) {
            currSum += arr[r];
            
            while (currSum > target && l <= r) {
                currSum -= arr[l];
                l++;
            }
            
            if (currSum == target) {
                int currLen = r - l + 1;
                
                if (l > 0 && minLenUpTo[l - 1] != Integer.MAX_VALUE / 2) {
                    minTotLen = Math.min(minTotLen, currLen + minLenUpTo[l - 1]);
                }
                
                if (r > 0) {
                    minLenUpTo[r] = Math.min(minLenUpTo[r - 1], currLen);
                } else {
                    minLenUpTo[r] = currLen;
                }
            } else {
                if (r > 0) {
                    minLenUpTo[r] = minLenUpTo[r - 1];
                }
            }
        }
        
        return minTotLen >= Integer.MAX_VALUE / 2 ? -1 : minTotLen;
    }
}