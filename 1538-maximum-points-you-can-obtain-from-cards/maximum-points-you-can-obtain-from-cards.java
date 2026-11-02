class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int window = n - k;
        int curr = 0, minSum = Integer.MAX_VALUE;
        int total = 0;

        for(int i = 0; i < n; i++){
            total += cardPoints[i];
            curr += cardPoints[i];

            if(i >= window) curr -= cardPoints[i - window];

            if(i >= window -1) minSum = Math.min(minSum , curr);
        }

        return total -minSum;
    }
}