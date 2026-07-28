class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n -1;
        int swaps = 0;

        while(l < r){

            while(l < r && nums[l] != 0) l++;

            while(l < r && nums[r] == 0) r--;

            if(l < r){

                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;

                l++;
                r--;
                swaps++;
            }
        }

        return swaps;
    }
}