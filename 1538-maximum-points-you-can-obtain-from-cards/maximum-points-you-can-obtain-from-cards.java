class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        for(int i = 0; i < n; i++){
            totalSum += cardPoints[i];
        }

        if(k == n) return totalSum;

        int l = 0;
        int currWinSum = 0;
        int minWinSum = Integer.MAX_VALUE;

        for(int r = 0; r < n; r++){
            currWinSum += cardPoints[r];

            if(r - l + 1 > n -k){
                currWinSum -= cardPoints[l];
                l++;
            }

            if(r -l +1 == n - k){
                minWinSum = Math.min(minWinSum , currWinSum);
            }
        }

        return totalSum -minWinSum;
    }
}