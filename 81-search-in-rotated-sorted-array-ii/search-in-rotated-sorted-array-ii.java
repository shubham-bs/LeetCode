class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n -1;

        while(l <= r){
            int mid = l + (r -l) /2;

            if(nums[mid] == target) return true;

            if(nums[l] == nums[mid] && nums[mid] == nums[r]){
                l++;
                r--;
                continue;
            }

            if(nums[l] <= nums[mid]){
                boolean left = nums[l] <= target && nums[mid] > target;

                if(left) r = mid -1;
                else l = mid +1;
            }else{
                boolean right = nums[r] >= target && nums[mid] < target;

                if(right) l = mid +1;
                else r = mid -1;
            }
        }

        return false;
    }
}