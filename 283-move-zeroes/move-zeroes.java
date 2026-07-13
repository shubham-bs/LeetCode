class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;

        while(i < nums.length && j < nums.length){
            while(i < nums.length && nums[i] != 0){
                i++;
            }

            if(j <= i){
                j = i +1;
            }

            while(j < nums.length && nums[j] == 0){
                j++;
            }

            if(i < nums.length && j < nums.length){
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
            }
        }
    }
}