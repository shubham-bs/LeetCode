class Solution {
    int dp[];

    public int fib(int n) {
        dp = new int[n +1];
        Arrays.fill(dp, -1);
        
        return solve(n);
    }

    private int solve(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;

        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = solve(n -1) + solve(n -2);

        return dp[n];
    }
}