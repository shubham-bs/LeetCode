class Solution {
    public long maxAlternatingSum(int[] nums) {
        int[] bucket = new int[40001];
        int min = 40_001, max = 0;

        for(int num: nums){
            bucket[Math.abs(num)]++;
            min = Math.min(min, Math.abs(num));
            max = Math.max(max, Math.abs(num));
        }

        int i = min, j = max;
        long ans = 0;

        while(i < j){
            ans += (long) j * j - (long) i * i;
            bucket[i]--;
            bucket[j]--;

            while(i <= max && bucket[i] == 0) i++;
            while(j >= min && bucket[j] == 0) j--;
        }

        if(i == j && (bucket[i] & 1) == 1){
            ans += (long) (i * i) ;
        }

        return ans;
    }
}