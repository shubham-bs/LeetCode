class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(
            ((long) m * k > n) || (k == n && m != 1)

        ) return -1;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int b: bloomDay){
            min = Math.min(min, b);
            max = Math.max(max, b);
        }

        int ans = -1;
        while(min <= max){
            int mid = min + (max - min)/ 2;

            int winSize = 0;
            int bouqetCount = 0;

            for(int i = 0; i < n; i++){
                if(bloomDay[i] <= mid){
                    winSize++;
                }else{
                    winSize = 0;
                }

                if(winSize == k){
                    bouqetCount++;
                    winSize = 0;
                }

                int remainingFlowers = n - 1 -i;
                int bouqetsNeeded = m -bouqetCount;

                if(remainingFlowers + winSize < bouqetsNeeded * k) break;
            }

            if(bouqetCount >= m){
                ans = mid;
                max = mid -1;
            }
            else min = mid +1;
        }
        return ans;
    }
}