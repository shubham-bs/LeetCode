public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];
            
            frequencyMap.put(currentNum, frequencyMap.getOrDefault(currentNum, 0) + 1);

            while (frequencyMap.get(currentNum) > k) {
                int leftNum = nums[left];
                frequencyMap.put(leftNum, frequencyMap.get(leftNum) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
