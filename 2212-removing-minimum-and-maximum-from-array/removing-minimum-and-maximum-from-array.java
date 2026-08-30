class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minI = 0;
        int max = Integer.MIN_VALUE;
        int maxI = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minI = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxI = i;
            }
        }

        int leftIdx = Math.min(minI, maxI);
        int rightIdx = Math.max(minI, maxI);


        int bothFromFront = rightIdx + 1;
        int bothFromBack = n - leftIdx;
        int oneFromFrontOneFromBack = (leftIdx + 1) + (n - rightIdx);
        
        return Math.min(bothFromFront, Math.min(bothFromBack,oneFromFrontOneFromBack));
    }
}