class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int sum = 0;
        int n = nums.length;

        for(int num : nums){
            if(min > num) min = num;
            sum += num;
        }

        return sum -(min * n);
    }
}