class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] preMax = new int[n];
        int[] preMin = new int[n];

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            preMax[i] = max;
        }

        int min = Integer.MAX_VALUE;
        for(int i = n -1; i >= 0; i--){
            min = Math.min(min, nums[i]);
            preMin[i] = min;
        }

        for (int i = 0; i < n; i++) {
            int instabilityScore = preMax[i] - preMin[i];
            if (instabilityScore <= k) {
                return i; 
            }
        }

        return -1;
    }
}