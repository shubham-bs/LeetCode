class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long minCoin = Long.MAX_VALUE;
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }
        
        long low = 1;
        long high = minCoin * k;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (countUniqueMultiples(0, 1, 0, mid, coins) >= k) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }
        return ans;
    }

    private long countUniqueMultiples(int index, long currentLcm, int coinCount, long mid, int[] coins) {
        if (index == coins.length) {
            if (coinCount == 0) return 0;
            long terms = mid / currentLcm;
            return (coinCount % 2 == 1) ? terms : -terms;
        }

        long total = countUniqueMultiples(index + 1, currentLcm, coinCount, mid, coins);

        long nextLcm = lcm(currentLcm, coins[index]);
        
        if (nextLcm <= mid) {
            total += countUniqueMultiples(index + 1, nextLcm, coinCount + 1, mid, coins);
        }

        return total;
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
