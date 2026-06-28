class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length -1;

        while(l <= h){
            int mid = l + (h -l) /2;

            if(target == nums[mid]){
                return mid;
            }

            if(nums[l] <= nums[mid]){

                boolean inLeft = target >= nums[l] && target < nums[mid];
                if(inLeft){
                    h = mid -1;
                }else{
                    l = mid +1;
                }

            }else{

                boolean inRight = target > nums[mid] && target <= nums[h];
                if(inRight){
                    l = mid + 1;
                }else{
                    h = mid -1;
                }
                
            }
        }
        return -1;
    }
}