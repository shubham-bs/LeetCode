class Solution {
    public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
        int n = nums.length, q = queries.length;
        boolean[] ans = new boolean[q];

        long[] prefixXor = new long[n +1];
        HashMap<Integer, Long> map = new HashMap<>();
        Random rand = new Random(42);

        for(int i = 0; i < n; i++){
            long h = map.computeIfAbsent(nums[i], x -> rand.nextLong());
            prefixXor[i +1] = prefixXor[i] ^ h;
        }

        int[][] orderedQueries = new int[q][3];
        for(int i = 0; i < q; i++){
            orderedQueries[i][0] = queries[i][0];
            orderedQueries[i][1] = queries[i][1];
            orderedQueries[i][2] = i;
        }

        Arrays.sort(orderedQueries, (a, b) -> Integer.compare(a[1], b[1]));

        int[] bit = new int[n +1];
        HashMap<Integer, Integer> lastSeen = new HashMap<>();
        int currR = 0;

        for(int[] query: orderedQueries){
            int l = query[0], r = query[1], originalIdx = query[2];

            while(currR <= r){
                int val = nums[currR];
                if(lastSeen.containsKey(val)){
                    updateBit(bit, lastSeen.get(val) +1, -1);
                }
                updateBit(bit, currR +1, 1);
                lastSeen.put(val, currR);
                currR++;
            }

            boolean isEven = (prefixXor[r +1] ^ prefixXor[l]) == 0;
            int distinct = queryBit(bit, r +1) - queryBit(bit, l);

            ans[originalIdx] = isEven &&(distinct == k);
        }

        return ans;
    }

    private void updateBit(int[] bit, int i, int delta){
        while(i < bit.length){
            bit[i] += delta;
            i += i & (-i);
        }
    }

    private int queryBit(int[] bit, int i){
        int sum = 0;
        while(i > 0){
            sum += bit[i];
            i -= i &(-i);
        }
        return sum;
    }
}