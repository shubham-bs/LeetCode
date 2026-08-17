public class Solution {
    private int[][] memo;
    private int[] prefixSums;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + stoneValue[i];
        }

        return solve(0, n - 1);
    }

    private int solve(int left, int right) {
        if (left == right) {
            return 0;
        }

        if (memo[left][right] != -1) {
            return memo[left][right];
        }

        int maxScore = 0;

        for (int i = left; i < right; i++) {
            int leftSum = getSum(left, i);
            int rightSum = getSum(i + 1, right);

            if (leftSum < rightSum) {
                maxScore = Math.max(maxScore, leftSum + solve(left, i));
            } else if (leftSum > rightSum) {
                maxScore = Math.max(maxScore, rightSum + solve(i + 1, right));
            } else {
                int chooseLeft = leftSum + solve(left, i);
                int chooseRight = rightSum + solve(i + 1, right);
                maxScore = Math.max(maxScore, Math.max(chooseLeft, chooseRight));
            }
        }

        return memo[left][right] = maxScore;
    }

    private int getSum(int l, int r) {
        return prefixSums[r + 1] - prefixSums[l];
    }
}
