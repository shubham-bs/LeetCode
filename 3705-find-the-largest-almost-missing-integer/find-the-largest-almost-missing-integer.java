class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        if (k == n) {
            int max = -1;
            for (int num : nums) {
                if (num > max) max = num;
            }
            return max;
        }
        
        int[] freq = new int[51];
        for (int num : nums) {
            freq[num]++;
        }
        
        if (k == 1) {
            for (int i = 50; i >= 0; i--) {
                if (freq[i] == 1) return i;
            }
            return -1;
        }
        
        int first = nums[0];
        int last = nums[n - 1];
        
        boolean firstValid = freq[first] == 1;
        boolean lastValid = freq[last] == 1;
        
        if (firstValid && lastValid) return Math.max(first, last);
        if (firstValid) return first;
        if (lastValid) return last;
        
        return -1;
    }
}
