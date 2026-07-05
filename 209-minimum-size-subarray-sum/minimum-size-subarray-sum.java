class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while(r < nums.length){
            sum += nums[r];

            while(sum >= target){
                ans = Math.min(ans, r -l +1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        
        if(ans == Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}