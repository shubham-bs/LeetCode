class Solution {
    public int minimumDeletions(int[] nums) {
        int minI = 0, maxI = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minI]) minI = i;
            if (nums[i] > nums[maxI]) maxI = i;
        }

        int leftIdx = Math.min(minI, maxI);
        int rightIdx = Math.max(minI, maxI);

        return Math.min(rightIdx + 1, 
        Math.min(n - leftIdx ,(leftIdx + 1) + (n - rightIdx)));
    }
}