class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;

        int maxNum = 0;
        for(int num :nums){
            maxNum = Math.max(maxNum, num);
        }

        int[] count = new int[maxNum +1];
        for(int num: nums){
            count[num]++;
        }

        int idx = 0;
        for(int i = 0; i < maxNum +1; i++){
            while(count[i] > 0){
                nums[idx] = i;
                count[i]--;
                idx++;
            }
        }

        long winSum = 0;
        int l = 0;
        for(int r = 0; r < n; r++){
            winSum += nums[r];

            if((long) nums[r] * (r -l +1) - winSum > k){
                winSum -= nums[l];
                l++;
            }
        }

        return n -l;
    }
}