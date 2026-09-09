class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long lowerBound = 1000; 

        while (lowerBound <= n) {
            ans += n - lowerBound + 1;
            
            if (lowerBound > n / 1000) {
                break; 
            }
            lowerBound *= 1000;
        }

        return ans;
    }
}