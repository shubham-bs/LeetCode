class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int i = 1, d = 1, ans = 1;

        for(int j = 1; j < nums.length; j++){
            if(nums[j] > nums[j -1]){
                i++;
                d = 1;
            }else if(nums[j] < nums[j -1]){
                d++;
                i = 1;
            }else{
                i = 1;
                d = 1;
            }

            ans = Math.max(ans, Math.max(i, d));
        }

        return ans;
    }
}