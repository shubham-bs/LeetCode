class Solution {
    public int climbStairs(int n) {
        if(n < 4) return n;

        int prev1 = 3;
        int prev2 = 2;

        for(int i = 4; i < n +1; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}