class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        int numSubsets = 1 << n;
        long[] subsetLcm = new long[numSubsets];
        int[] subsetSign = new int[numSubsets];
        
        subsetLcm[0] = 1; 
        for (int mask = 1; mask < numSubsets; mask++) {
            int lsb = Integer.numberOfTrailingZeros(mask);
            long prevLcm = subsetLcm[mask ^ (1 << lsb)];
            subsetLcm[mask] = lcm(prevLcm, coins[lsb]);
            subsetSign[mask] = (Integer.bitCount(mask) % 2 == 1) ? 1 : -1;
        }

        long low = 1;
        long minCoin = coins[0];
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }
        long high = minCoin * k; 
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (countMultiples(mid, numSubsets, subsetLcm, subsetSign) >= k) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }
        return ans;
    }

    private long countMultiples(long mid, int numSubsets, long[] subsetLcm, int[] subsetSign) {
        long count = 0;
        for (int mask = 1; mask < numSubsets; mask++) {
            count += subsetSign[mask] * (mid / subsetLcm[mask]);
        }
        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
