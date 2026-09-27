class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.min(nums[0], nums[1]);

        int l = 0, r = n -1;

        while(l <= r){
            int mid = l + (r - l)/ 2;

            if(mid +1 < n && nums[mid] == nums[mid +1]){

                if(mid % 2 == 0) l = mid +1;
                else r = mid -1;

            }else if(mid -1 >= 0 && nums[mid -1] == nums[mid]){

                if((mid -1) % 2 == 0) l = mid +1;
                else r = mid -1;

            }else return nums[mid];
        }

        return 0;
    }
}