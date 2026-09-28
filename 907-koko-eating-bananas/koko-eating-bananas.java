class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int min = 1, max = Integer.MIN_VALUE;

        for(int pile: piles){
            max = Math.max(max, pile);
        }

        int ans = max;

        while(min <= max){
            int mid = min + (max - min)/ 2;
            long currH = 0;

            for(int pile : piles){
                currH += (pile + mid -1)/ mid;
            }

            if(currH <= h){
                ans = mid;
                max = mid -1;
            }else min = mid +1;
        }

        return ans;
    }
}