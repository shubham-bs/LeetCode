class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean nonZero = false;
        int n = nums.length;

        for(int num: nums){
            xor ^= num;
            if(num != 0) nonZero = true;
        }

        if(xor != 0) return n;
        if(nonZero) return n -1;
        return 0;
    }
}