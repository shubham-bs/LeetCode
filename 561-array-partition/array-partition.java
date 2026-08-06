class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;
        int i = 0;
        int j = 1;

        while(j < nums.length){
            ans += Math.min(nums[i], nums[j]);
            i += 2;
            j += 2;
        }

        return ans;
    }
}