class Solution {
    private static class Interval {
        int l, r, weight, id;
        
        Interval(int l, int r, int weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    private static class State {
        long weight;
        int[] indices;

        State(long weight, int[] indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervalsInput) {
        int n = intervalsInput.size();
        Interval[] intervals = new Interval[n];
        
        for (int i = 0; i < n; i++) {
            List<Integer> inter = intervalsInput.get(i);
            intervals[i] = new Interval(inter.get(0), inter.get(1), inter.get(2), i);
        }

        
        Arrays.sort(intervals, (a, b) -> {
            if (a.l != b.l) return Integer.compare(a.l, b.l);
            if (a.r != b.r) return Integer.compare(a.r, b.r);
            return Integer.compare(a.id, b.id);
        });

        int[] nextIdx = new int[n];
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1, ans = n;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (intervals[mid].l > intervals[i].r) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            nextIdx[i] = ans;
        }

        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = new State(0, new int[0]);
            for (int k = 1; k <= 4; k++) {
                dp[i][k] = new State(-1, null); 
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {
                State best = dp[i + 1][k];

                State nextState = dp[nextIdx[i]][k - 1];
                if (nextState.weight != -1) {
                    long takeWeight = intervals[i].weight + nextState.weight;
                    int[] takeIndices = new int[k];
                    takeIndices[0] = intervals[i].id;
                    System.arraycopy(nextState.indices, 0, takeIndices, 1, k - 1);
                    Arrays.sort(takeIndices); 

                    State takeState = new State(takeWeight, takeIndices);
                    best = compareStates(best, takeState);
                }
                dp[i][k] = best;
            }
        }

        State ansState = new State(-1, null);
        for (int k = 1; k <= 4; k++) {
            ansState = compareStates(ansState, dp[0][k]);
        }

        return ansState.indices;
    }

    private State compareStates(State s1, State s2) {
        if (s1.weight != s2.weight) {
            return s1.weight > s2.weight ? s1 : s2;
        }
        if (s1.weight == -1) return s1; 

        for (int i = 0; i < s1.indices.length; i++) {
            if (s1.indices[i] != s2.indices[i]) {
                return s1.indices[i] < s2.indices[i] ? s1 : s2;
            }
        }
        return s1;
    }
}

