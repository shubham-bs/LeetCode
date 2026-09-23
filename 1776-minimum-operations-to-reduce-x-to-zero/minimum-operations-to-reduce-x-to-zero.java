class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int maxSum = 0;
        for(int num: nums){
            maxSum += num;
        }

        int diffSum = maxSum - x;
        if(diffSum < 0) return -1;
        if(diffSum == 0) return n;

        int maxLen = -1;
        int currSum = 0;

        int l = 0;
        int i = 0;

        while(i < n){
            currSum += nums[i];

            while(currSum > diffSum){
                currSum -= nums[l];
                l++;
            }

            if(currSum == diffSum) maxLen = Math.max(maxLen, i -l +1);;
            
            i++;
        }

        return maxLen == -1 ? -1 : n -maxLen;
    }
}