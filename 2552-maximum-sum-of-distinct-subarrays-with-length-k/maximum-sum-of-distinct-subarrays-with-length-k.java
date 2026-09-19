class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, currSum = 0;
        int i = 0, j = 0, n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(j < n){
            currSum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while(j -i +1 > k || map.get(nums[j]) > 1){
                currSum -= nums[i];
                map.put(nums[i], map.get(nums[i]) -1);
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