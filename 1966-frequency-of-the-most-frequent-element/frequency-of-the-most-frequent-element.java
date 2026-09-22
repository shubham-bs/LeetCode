class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int maxFreq = 0;
        int l = 0;
        
        long winSum = 0;
        for(int r = 0; r < nums.length; r++){
            winSum += nums[r];

            while((long) nums[r] * (r -l +1) - winSum > k){
                winSum -= nums[l];
                l++;
            }

            maxFreq = Math.max(maxFreq, r -l +1);
        }

        return maxFreq;
    }
}