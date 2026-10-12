class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[31];
        long MOD = 1_000_000_007L;

        for(int num: nums){
            for(int bit = 0; bit < 31; bit++){
                if((num & (1 << bit)) != 0) count[bit]++;
            }
        }

        long ans = 0;
        for(int i = 0; i < k; i++){
            int num = 0;

            for(int bit = 0; bit < 31; bit++){
                if(count[bit] > 0){
                    num = num | (1 << bit);
                    count[bit]--;
                }
            }

            ans = (ans + (long) num * num) % MOD;
        }

        return (int) ans;
    }
}