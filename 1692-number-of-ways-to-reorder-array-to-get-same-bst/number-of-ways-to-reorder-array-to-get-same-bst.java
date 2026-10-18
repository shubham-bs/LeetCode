class Solution {
    static final long MOD = 1_000_000_007L;
    long[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        return (int) ((solve(nums) - 1 + MOD) % MOD);
    }

    private long solve(int[] nums) {
        if (nums.length <= 2) return 1;
        int root = nums[0];

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < root) left.add(nums[i]);
            else right.add(nums[i]);
        }

        long leftWays = solve(toArray(left));
        long rightWays = solve(toArray(right));

        int L = left.size();
        int R = right.size();

        return comb[L + R][L] * leftWays % MOD * rightWays % MOD;
    }

    private int[] toArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        return arr;
    }
}