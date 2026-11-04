class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        Window window = new Window();

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        for (int i = 0; i <= n - x; i++) {
            cost[i] = window.getCost();

            if (i < n - x) {
                window.remove(nums[i]);
                window.add(nums[i + x]);
            }
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], INF);
        }

        Arrays.fill(dp[0], 0);

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];

                if (j >= x && dp[i - 1][j - x] != INF) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - 1][j - x] + cost[j - x]
                    );
                }
            }
        }

        return dp[k][n];
    }

    static class Window {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        long sumLeft = 0;
        long sumRight = 0;

        int sizeLeft = 0;
        int sizeRight = 0;

        void add(int val) {
            if (left.isEmpty() || val <= left.lastKey()) {
                left.merge(val, 1, Integer::sum);
                sumLeft += val;
                sizeLeft++;
            } else {
                right.merge(val, 1, Integer::sum);
                sumRight += val;
                sizeRight++;
            }

            balance();
        }

        void remove(int val) {
            if (left.containsKey(val)) {
                removeFrom(left, val);
                sumLeft -= val;
                sizeLeft--;
            } else {
                removeFrom(right, val);
                sumRight -= val;
                sizeRight--;
            }

            balance();
        }

        void removeFrom(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }

        void balance() {
            while (sizeLeft > sizeRight + 1) {
                int val = left.lastKey();

                removeFrom(left, val);
                sumLeft -= val;
                sizeLeft--;

                right.merge(val, 1, Integer::sum);
                sumRight += val;
                sizeRight++;
            }

            while (sizeLeft < sizeRight) {
                int val = right.firstKey();

                removeFrom(right, val);
                sumRight -= val;
                sizeRight--;

                left.merge(val, 1, Integer::sum);
                sumLeft += val;
                sizeLeft++;
            }
        }

        long getCost() {
            long median = left.lastKey();

            return median * sizeLeft - sumLeft
                 + sumRight - median * sizeRight;
        }
    }
}