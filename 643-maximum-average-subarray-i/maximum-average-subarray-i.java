class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int curr = 0;

        for(int i = 0; i < k; i++){
            curr += nums[i];
        }

        int max = curr;
        int r = k;

        while(r < nums.length){
            curr += nums[r] - nums[r -k];
            max = Math.max(max, curr);
            r++;
        }

        return (double) max /k;
    }
}