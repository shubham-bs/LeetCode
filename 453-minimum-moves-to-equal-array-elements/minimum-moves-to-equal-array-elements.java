class Solution {
    public int minMoves(int[] nums) {
        if(nums.length==1) return 0;
        if(nums.length==2) return nums[1]-nums[0];;
        int n = 1, a = 0 , b = 0, s = 0;
        Arrays.sort(nums);
        for(int i= nums.length-1;i>=1;i--){
            a = nums[i]+s; b=nums[i-1] + s;
            s = s + n*(a-b);
            n++;
        }
        return s;
    }
}