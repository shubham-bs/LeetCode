class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];

        for(int i = 1; i < n; i++){
            pre[i] = pre[i -1] + nums[i -1];
        }

        for(int i = n -2; i >= 0; i--){
            suf[i] = suf[i +1] + nums[i +1];
        }
        
        int i;
        for(i = 0; i < n; i++){
            if(pre[i] == suf[i]) return i;
        }

        if(i == 0 || i == n -1) return 0;

        return -1;
    }
}