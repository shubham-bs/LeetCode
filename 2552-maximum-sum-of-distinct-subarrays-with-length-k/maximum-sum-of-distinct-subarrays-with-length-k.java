class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, currSum = 0;
        int i = 0, j = 0, n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        while(j < n){
            while(set.contains(nums[j])){
                currSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            currSum += nums[j];
            set.add(nums[j]);

            if(j -i +1 > k){
                currSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            if(j -i +1 == k){
                maxSum = Math.max(maxSum, currSum);
            }

            j++;
        }

        return maxSum;
    }
}