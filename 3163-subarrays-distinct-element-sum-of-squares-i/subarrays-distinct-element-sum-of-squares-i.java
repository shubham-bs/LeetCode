class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0, n = nums.size();

        for(int i = 0; i < n; i++){
            int distinct = 0;
            boolean[] set = new boolean[101];

            for(int j = i; j < n; j++){
                if(!set[nums.get(j)]){
                    set[nums.get(j)] = true;
                    distinct++;
                }

                ans += distinct * distinct;
            }
        }

        return ans;
    }
}