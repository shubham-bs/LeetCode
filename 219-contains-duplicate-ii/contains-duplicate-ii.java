class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        int l = 0;
        int r;

        for(r = 0; r <= k && r < nums.length; r++){
            if(!set.add(nums[r])) return true;
        }

        while(r < n){
            set.remove(nums[l]);
            l++;

            if(!set.add(nums[r])) return true;
            r++;
        }

        return false;
    }
}