class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int max = nums[0];
        int pos = nums[0];
        int neg = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = pos;
                pos = neg;
                neg = temp;
            }

            pos = Math.max(pos * nums[i], nums[i]);
            neg = Math.min(neg * nums[i], nums[i]);

            max = Math.max(max, pos);
        }

        return max;
    }
}