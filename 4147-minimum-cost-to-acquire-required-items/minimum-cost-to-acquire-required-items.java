class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long a = (long) cost1 * need1 + (long) cost2 * need2;

        long b = (long) Math.min(need1, need2) * costBoth +
                 (long) Math.max(0, need1 -need2) * cost1 +
                 (long) Math.max(0, need2 -need1) * cost2;

        long c = (long) Math.max(need1, need2) * costBoth;

        return Math.min(a, Math.min(b, c));
    }
}