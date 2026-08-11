class Solution {
    public int missingInteger(int[] nums) {
        int prefix = nums[0];
        int n = nums.length;
        int i = 1;


        while(i < n){
            if(nums[i] != nums[i -1] +1) break;
            prefix += nums[i];
            i++;
        }

        Arrays.sort(nums);

       for(int j = 0; j < n; j++){
            if(prefix == nums[j]){
                prefix++;
            }
       }

       return prefix;

    }
}